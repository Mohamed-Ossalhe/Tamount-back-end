package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.VerificationCodeMapper;
import ma.tamount.backend.models.entities.VerificationCode;
import ma.tamount.backend.models.requests.VerificationCodeRequest;
import ma.tamount.backend.models.responses.VerificationCodeResponse;
import ma.tamount.backend.repositories.VerificationCodeRepository;
import ma.tamount.backend.services.VerificationCodeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * Service class for managing verification-code-related operations.
 *
 * <p>This service class provides methods for retrieving verification code data based on various criteria,
 * creating verification code information, and handling user verification code process.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class VerificationCodeServiceImplementation extends AbstractService<UUID, VerificationCodeRequest, VerificationCodeResponse, VerificationCode, VerificationCodeRepository, VerificationCodeMapper> implements VerificationCodeService {
}
