package ma.tamount.backend.mappers;

import ma.tamount.backend.interfaces.GenericMapper;
import ma.tamount.backend.models.entities.User;
import ma.tamount.backend.models.requests.RegistrationRequest;
import ma.tamount.backend.models.responses.UserResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link RegistrationRequest}, {@link UserResponse}, and {@link User} entities.
 * Extends the generic {@link GenericMapper} interface with UUID as the identifier type.
 *
 * @author Mohamed Ossalhe
 */

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface UserMapper extends GenericMapper<UUID, RegistrationRequest, UserResponse, User> {
}
