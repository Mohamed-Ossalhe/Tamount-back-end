package ma.tamount.backend.mappers;

import ma.tamount.backend.interfaces.GenericMapper;
import ma.tamount.backend.models.entities.Phone;
import ma.tamount.backend.models.requests.PhoneRequest;
import ma.tamount.backend.models.responses.PhoneResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link PhoneRequest}, {@link PhoneResponse}, and {@link Phone} entities.
 * Extends the generic {@link GenericMapper} interface with UUID as the identifier type.
 *
 * @author Mohamed Ossalhe
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface PhoneMapper extends GenericMapper<UUID, PhoneRequest, PhoneResponse, Phone> {
}
