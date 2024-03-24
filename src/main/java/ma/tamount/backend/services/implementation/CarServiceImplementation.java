package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.CarMapper;
import ma.tamount.backend.models.entities.Car;
import ma.tamount.backend.models.entities.User;
import ma.tamount.backend.models.requests.CarRequest;
import ma.tamount.backend.models.responses.CarResponse;
import ma.tamount.backend.repositories.CarRepository;
import ma.tamount.backend.services.AuthenticationService;
import ma.tamount.backend.services.CarService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

/**
 * Service class for managing car-related operations.
 *
 * <p>This service class provides methods for retrieving car data based on various criteria,
 * updating car information.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class CarServiceImplementation extends AbstractService<UUID, CarRequest, CarResponse, Car, CarRepository, CarMapper> implements CarService {
    private final CarMapper mapper;
    private final CarRepository repository;
    private final AuthenticationService authenticationService;
    @Override
    public List<CarResponse> findAllCarsByUser() {
        User user = authenticationService.authenticatedUser();
        List<Car> cars = repository.findAllByUser(user);
        return mapper.toResponse(cars);
    }
}
