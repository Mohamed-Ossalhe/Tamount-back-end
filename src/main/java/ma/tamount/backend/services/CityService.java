package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.CityRequest;
import ma.tamount.backend.models.responses.CityResponse;

import java.util.UUID;

/**
 * Service interface for managing City entity.
 * @author Mohamed Ossalhe
 */

public interface CityService extends GenericService<UUID, CityRequest, CityResponse> {
}
