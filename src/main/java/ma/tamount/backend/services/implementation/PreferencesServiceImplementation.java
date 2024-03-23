package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.PreferencesMapper;
import ma.tamount.backend.models.entities.Preferences;
import ma.tamount.backend.models.requests.PreferencesRequest;
import ma.tamount.backend.models.responses.PreferencesResponse;
import ma.tamount.backend.repositories.PreferencesRepository;
import ma.tamount.backend.services.PreferencesService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * Service class for managing Preferences operations.
 *
 * <p>This service class provides methods for retrieving Preferences data based on various criteria.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class PreferencesServiceImplementation extends AbstractService<UUID, PreferencesRequest, PreferencesResponse, Preferences, PreferencesRepository, PreferencesMapper> implements PreferencesService {
}
