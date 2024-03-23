package ma.tamount.backend.mappers;

import ma.tamount.backend.interfaces.GenericMapper;
import ma.tamount.backend.models.entities.PaymentHistory;
import ma.tamount.backend.models.requests.PaymentHistoryRequest;
import ma.tamount.backend.models.responses.PaymentHistoryResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link PaymentHistoryRequest}, {@link PaymentHistoryResponse}, and {@link PaymentHistory} entities.
 * Extends the generic {@link GenericMapper} interface with UUID as the identifier type.
 *
 * @author Mohamed Ossalhe
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {BookingMapper.class}
)
public interface PaymentHistoryMapper extends GenericMapper<UUID, PaymentHistoryRequest, PaymentHistoryResponse, PaymentHistory> {
}
