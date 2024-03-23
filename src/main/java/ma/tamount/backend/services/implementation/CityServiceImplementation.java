package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.CityMapper;
import ma.tamount.backend.models.entities.City;
import ma.tamount.backend.models.requests.CityRequest;
import ma.tamount.backend.models.responses.CityResponse;
import ma.tamount.backend.repositories.CityRepository;
import ma.tamount.backend.services.CityService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * Service class for managing city-related operations.
 *
 * <p>This service class provides methods for retrieving city data based on various criteria,
 * updating city information.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class CityServiceImplementation extends AbstractService<UUID, CityRequest, CityResponse, City, CityRepository, CityMapper> implements CityService {
}
