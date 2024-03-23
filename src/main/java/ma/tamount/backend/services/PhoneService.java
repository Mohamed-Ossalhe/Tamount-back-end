package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.PhoneRequest;
import ma.tamount.backend.models.responses.PhoneResponse;

import java.util.UUID;


/**
 * Service interface for managing Phone entity.
 * @author Mohamed Ossalhe
 */
public interface PhoneService extends GenericService<UUID, PhoneRequest, PhoneResponse> {
}
