package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.LocationRequest;
import ma.tamount.backend.models.responses.LocationResponse;

import java.util.UUID;

/**
 * Service interface for managing Location entity.
 * @author Mohamed Ossalhe
 */
public interface LocationService extends GenericService<UUID, LocationRequest, LocationResponse> {
}
