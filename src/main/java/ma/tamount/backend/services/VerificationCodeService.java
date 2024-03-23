package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.VerificationCodeRequest;
import ma.tamount.backend.models.responses.VerificationCodeResponse;

import java.util.UUID;

/**
 * Service interface for managing Ride entity.
 * @author Mohamed Ossalhe
 */
public interface VerificationCodeService extends GenericService<UUID, VerificationCodeRequest, VerificationCodeResponse> {
}
