package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.RideMapper;
import ma.tamount.backend.models.entities.Ride;
import ma.tamount.backend.models.requests.RideRequest;
import ma.tamount.backend.models.responses.RideResponse;
import ma.tamount.backend.repositories.RideRepository;
import ma.tamount.backend.services.RideService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * Service class for managing ride-related operations.
 *
 * <p>This service class provides methods for retrieving ride data based on various criteria,
 * updating ride information, and handling ride status changes.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class RideServiceImplementation extends AbstractService<UUID, RideRequest, RideResponse, Ride, RideRepository, RideMapper> implements RideService {
}
