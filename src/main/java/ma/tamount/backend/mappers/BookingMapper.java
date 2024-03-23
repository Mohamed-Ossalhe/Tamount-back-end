package ma.tamount.backend.mappers;

import ma.tamount.backend.interfaces.GenericMapper;
import ma.tamount.backend.models.entities.Booking;
import ma.tamount.backend.models.requests.BookingRequest;
import ma.tamount.backend.models.responses.BookingResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link BookingRequest}, {@link BookingResponse}, and {@link Booking} entities.
 * Extends the generic {@link GenericMapper} interface with UUID as the identifier type.
 *
 * @author Mohamed Ossalhe
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface BookingMapper extends GenericMapper<UUID, BookingRequest, BookingResponse, Booking> {
}
