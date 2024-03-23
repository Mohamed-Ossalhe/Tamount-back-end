package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.LocationMapper;
import ma.tamount.backend.models.entities.Location;
import ma.tamount.backend.models.requests.LocationRequest;
import ma.tamount.backend.models.responses.LocationResponse;
import ma.tamount.backend.repositories.LocationRepository;
import ma.tamount.backend.services.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * Service class for managing location-related operations.
 *
 * <p>This service class provides methods for retrieving location data based on various criteria,
 * updating location information, and handling location status changes.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class LocationServiceImplementation extends AbstractService<UUID, LocationRequest, LocationResponse, Location, LocationRepository, LocationMapper> implements LocationService {
}
