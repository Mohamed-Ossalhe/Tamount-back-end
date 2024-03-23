package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.VerificationCodeRequest;
import ma.tamount.backend.models.responses.VerificationCodeResponse;
import ma.tamount.backend.services.VerificationCodeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class handling verification-code-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of verification code.
 * It utilizes the {@link VerificationCodeService} to fetch verification code data and returns the results in the form of {@link VerificationCodeResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/verification-codes")
public class VerificationCodeController extends AbstractController<UUID, VerificationCodeRequest, VerificationCodeResponse, VerificationCodeService> {
}
