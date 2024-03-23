package ma.tamount.backend.mappers;

import ma.tamount.backend.interfaces.GenericMapper;
import ma.tamount.backend.models.entities.Ride;
import ma.tamount.backend.models.requests.RideRequest;
import ma.tamount.backend.models.responses.RideResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

/**
 * Mapper interface for converting between {@link RideRequest}, {@link RideResponse}, and {@link Ride} entities.
 * Extends the generic {@link GenericMapper} interface with UUID as the identifier type.
 *
 * @author Mohamed Ossalhe
 */
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {LocationMapper.class, UserMapper.class, CarMapper.class}
)
public interface RideMapper extends GenericMapper<UUID, RideRequest, RideResponse, Ride> {
}
