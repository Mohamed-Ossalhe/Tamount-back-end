package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.PaymentHistoryRequest;
import ma.tamount.backend.models.responses.PaymentHistoryResponse;

import java.util.UUID;


/**
 * Service interface for managing Payment history entity.
 * @author Mohamed Ossalhe
 */
public interface PaymentHistoryService extends GenericService<UUID, PaymentHistoryRequest, PaymentHistoryResponse> {
}
