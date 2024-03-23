package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.PhoneRequest;
import ma.tamount.backend.models.responses.PhoneResponse;
import ma.tamount.backend.services.PhoneService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class handling phone-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of phone.
 * It utilizes the {@link PhoneService} to fetch phone data and returns the results in the form of {@link PhoneResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/phones")
public class PhoneController extends AbstractController<UUID, PhoneRequest, PhoneResponse, PhoneService> {
}
