package ma.tamount.backend.mappers;

import ma.tamount.backend.interfaces.GenericMapper;
import ma.tamount.backend.models.entities.VerificationCode;
import ma.tamount.backend.models.requests.VerificationCodeRequest;
import ma.tamount.backend.models.responses.VerificationCodeResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link VerificationCodeRequest}, {@link VerificationCodeResponse}, and {@link VerificationCode} entities.
 * Extends the generic {@link GenericMapper} interface with UUID as the identifier type.
 *
 * @author Mohamed Ossalhe
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface VerificationCodeMapper extends GenericMapper<UUID, VerificationCodeRequest, VerificationCodeResponse, VerificationCode> {
}
