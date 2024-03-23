package ma.tamount.backend.services;

import ma.tamount.backend.interfaces.GenericService;
import ma.tamount.backend.models.requests.PreferencesRequest;
import ma.tamount.backend.models.responses.PreferencesResponse;

import java.util.UUID;

/**
 * Service interface for managing Preferences entity.
 * @author Mohamed Ossalhe
 */

public interface PreferencesService extends GenericService<UUID, PreferencesRequest, PreferencesResponse> {
}
