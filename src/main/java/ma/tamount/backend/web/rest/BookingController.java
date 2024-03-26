package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.BookingRequest;
import ma.tamount.backend.models.responses.BookingResponse;
import ma.tamount.backend.services.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Controller class handling ride-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of ride.
 * It utilizes the {@link BookingService} to fetch user data and returns the results in the form of {@link BookingResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
public class BookingController extends AbstractController<UUID, BookingRequest, BookingResponse, BookingService> {
    private final BookingService service;
    @GetMapping("/owned")
    public ResponseEntity<List<BookingResponse>> findAllByUser() {
        return new ResponseEntity<>(service.findAllByUser(), HttpStatus.OK);
    }
}
