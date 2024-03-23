package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.RideRequest;
import ma.tamount.backend.models.responses.RideResponse;
import ma.tamount.backend.services.RideService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
