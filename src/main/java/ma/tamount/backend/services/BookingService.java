package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.BookingRequest;
import ma.tamount.backend.models.responses.BookingResponse;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing Booking entity.
 * @author Mohamed Ossalhe
 */
public interface BookingService extends GenericService<UUID, BookingRequest, BookingResponse> {
    List<BookingResponse> findAllByUser();
}
