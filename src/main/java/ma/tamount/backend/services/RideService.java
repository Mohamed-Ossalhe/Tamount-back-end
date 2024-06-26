package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.RideRequest;
import ma.tamount.backend.models.requests.SearchRequest;
import ma.tamount.backend.models.responses.RideResponse;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing Ride entity.
 * @author Mohamed Ossalhe
 */
public interface RideService extends GenericService<UUID, RideRequest, RideResponse> {
    List<RideResponse> searchRidesByDepartureOrArrivalOrDateOrSeats(SearchRequest request);
    List<RideResponse> findRidesByUser();
}
