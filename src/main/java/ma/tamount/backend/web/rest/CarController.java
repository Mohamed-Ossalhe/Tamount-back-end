package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.CarRequest;
import ma.tamount.backend.models.responses.CarResponse;
import ma.tamount.backend.services.CarService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class handling ride-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of cars.
 * It utilizes the {@link CarService} to fetch car data and returns the results in the form of {@link CarResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarController extends AbstractController<UUID, CarRequest, CarResponse, CarService> {
}
