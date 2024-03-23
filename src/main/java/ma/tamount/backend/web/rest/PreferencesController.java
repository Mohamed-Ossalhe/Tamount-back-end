package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.PreferencesRequest;
import ma.tamount.backend.models.responses.PreferencesResponse;
import ma.tamount.backend.services.PreferencesService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class handling Preferences-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of Preferences.
 * It utilizes the {@link PreferencesService} to fetch Preferences data and returns the results in the form of {@link PreferencesResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/preferences")
public class PreferencesController extends AbstractController<UUID, PreferencesRequest, PreferencesResponse, PreferencesService> {
}
