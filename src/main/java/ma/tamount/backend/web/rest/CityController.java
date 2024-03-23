package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.CityRequest;
import ma.tamount.backend.models.responses.CityResponse;
import ma.tamount.backend.services.CityService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class handling city-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of cities.
 * It utilizes the {@link CityService} to fetch car data and returns the results in the form of {@link CityResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cities")
public class CityController extends AbstractController<UUID, CityRequest, CityResponse, CityService> {
}
