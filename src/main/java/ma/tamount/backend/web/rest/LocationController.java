package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.LocationRequest;
import ma.tamount.backend.models.responses.LocationResponse;
import ma.tamount.backend.services.LocationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class handling location-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of location.
 * It utilizes the {@link LocationService} to fetch location data and returns the results in the form of {@link LocationResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController extends AbstractController<UUID, LocationRequest, LocationResponse, LocationService> {
}
