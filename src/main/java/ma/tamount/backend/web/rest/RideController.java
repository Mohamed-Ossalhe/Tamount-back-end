package ma.tamount.backend.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.RideRequest;
import ma.tamount.backend.models.requests.SearchRequest;
import ma.tamount.backend.models.responses.RideResponse;
import ma.tamount.backend.services.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controller class handling ride-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of ride.
 * It utilizes the {@link RideService} to fetch ride data and returns the results in the form of {@link RideResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rides")
public class RideController extends AbstractController<UUID, RideRequest, RideResponse, RideService> {
    private final RideService service;
    @PostMapping("/search")
    public ResponseEntity<List<RideResponse>> searchRides(@Valid @RequestBody SearchRequest request) {
        return new ResponseEntity<>(service.searchRidesByDepartureOrArrivalOrDateOrSeats(request), HttpStatus.OK);
    }

    @GetMapping("/created")
    public ResponseEntity<List<RideResponse>> findRidesByUser() {
        return new ResponseEntity<>(service.findRidesByUser(), HttpStatus.OK);
    }
}
