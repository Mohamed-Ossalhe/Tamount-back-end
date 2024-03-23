package ma.tamount.backend.mappers;

import ma.tamount.backend.interfaces.GenericMapper;
import ma.tamount.backend.models.entities.Preferences;
import ma.tamount.backend.models.requests.PreferencesRequest;
import ma.tamount.backend.models.responses.PreferencesResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link PreferencesRequest}, {@link PreferencesResponse}, and {@link Preferences} entities.
 * Extends the generic {@link GenericMapper} interface with UUID as the identifier type.
 *
 * @author Mohamed Ossalhe
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {UserMapper.class}
)
public interface PreferencesMapper extends GenericMapper<UUID, PreferencesRequest, PreferencesResponse, Preferences> {
}
