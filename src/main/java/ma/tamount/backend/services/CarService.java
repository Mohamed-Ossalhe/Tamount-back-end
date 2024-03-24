package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.CarRequest;
import ma.tamount.backend.models.responses.CarResponse;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing Car entity.
 * @author Mohamed Ossalhe
 */

public interface CarService extends GenericService<UUID, CarRequest, CarResponse> {
    List<CarResponse> findAllCarsByUser();
}
