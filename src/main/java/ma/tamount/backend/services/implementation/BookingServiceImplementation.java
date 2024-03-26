package ma.tamount.backend.services.implementation;

import com.stripe.model.Charge;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.exceptions.ResourceAlreadyExistsException;
import ma.tamount.backend.mappers.BookingMapper;
import ma.tamount.backend.mappers.RideMapper;
import ma.tamount.backend.mappers.UserMapper;
import ma.tamount.backend.models.entities.Booking;
import ma.tamount.backend.models.entities.PaymentHistory;
import ma.tamount.backend.models.entities.User;
import ma.tamount.backend.models.enums.PaymentStatus;
import ma.tamount.backend.models.requests.BookingRequest;
import ma.tamount.backend.models.responses.BookingResponse;
import ma.tamount.backend.repositories.BookingRepository;
import ma.tamount.backend.repositories.PaymentHistoryRepository;
import ma.tamount.backend.services.AuthenticationService;
import ma.tamount.backend.services.BookingService;
import ma.tamount.backend.services.StripeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing booking-related operations.
 *
 * <p>This service class provides methods for retrieving booking data based on various criteria,
 * updating booking information, and handling booking status changes.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class BookingServiceImplementation extends AbstractService<UUID, BookingRequest, BookingResponse, Booking, BookingRepository, BookingMapper> implements BookingService {
    private final StripeService stripeService;
    private final BookingMapper mapper;
    private final RideMapper rideMapper;
    private final UserMapper userMapper;
    private final BookingRepository repository;
    private final PaymentHistoryRepository paymentHistoryRepository;
    private final AuthenticationService authenticationService;
    @Override
    public Optional<BookingResponse> create(BookingRequest request) {
        Optional<Booking> booking = repository.findBookingByRideAndUser(rideMapper.toEntityFromResponse(request.ride()), userMapper.toEntityFromResponse(request.user()));
        if (booking.isPresent()) throw new ResourceAlreadyExistsException("You already booked this ride");
        Charge charges = stripeService.charge(request.chargeRequest());
        Booking bookingToSave = mapper.toEntityFromRequest(request);
        Booking savedBooking = repository.saveAndFlush(bookingToSave);

        PaymentHistory paymentHistory = PaymentHistory.builder()
                .paymentMethod(request.chargeRequest().paymentMethod())
                .amount((double) charges.getAmount() / 100)
                .booking(savedBooking)
                .currency(request.chargeRequest().currency())
                .status(PaymentStatus.valueOf(charges.getStatus().toUpperCase()))
                .transaction(charges.getBalanceTransaction())
                .receiptUrl(charges.getReceiptUrl())
                .description(charges.getDescription())
                .build();
        paymentHistoryRepository.saveAndFlush(paymentHistory);
        return Optional.of(mapper.toResponse(savedBooking));
    }

    @Override
    public List<BookingResponse> findAllByUser() {
        User user = authenticationService.authenticatedUser();
        return mapper.toResponse(repository.findAllByUser(user));
    }
}
