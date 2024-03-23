package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.BookingMapper;
import ma.tamount.backend.models.entities.Booking;
import ma.tamount.backend.models.requests.BookingRequest;
import ma.tamount.backend.models.responses.BookingResponse;
import ma.tamount.backend.repositories.BookingRepository;
import ma.tamount.backend.services.BookingService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
}
