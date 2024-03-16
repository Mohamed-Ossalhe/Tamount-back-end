package ma.tamount.backend.interfaces;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.sql.Timestamp;
import java.util.List;

/**
 * Generic mapper interface for converting between DTOs (Data Transfer Objects) and entities.
 *
 * @param <T>     The type of the entity's identifier.
 * @param <R>    The type of the request DTO.
 * @param <S>    The type of the response DTO.
 * @param <E> The type of the entity.
 * @author Mohamed Ossalhe
 */
public interface GenericMapper<T, R extends GenericRequest, S extends GenericResponse, E extends GenericEntity<T>> {

    /**
     * Converts a request DTO to an entity.
     *
     * @param request Request DTO.
     * @return Converted entity.
     */
    E toEntityFromRequest(R request);

    /**
     * Converts a response DTO to an entity.
     *
     * @param response Response DTO.
     * @return Converted entity.
     */
    E toEntityFromResponse(S response);

    /**
     * Converts an entity to a response DTO.
     *
     * @param entity Entity.
     * @return Converted response DTO.
     */
    S toResponse(E entity);

    List<S> toResponse(List<E> entity);

    /**
     * Applies partial updates from the request DTO to the entity, ignoring null values.
     *
     * @param request Request DTO containing partial updates.
     * @param entity  Entity to be updated.
     * @return Updated entity.
     */
    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    E applyPartialUpdates(R request, @MappingTarget E entity);

    /**
     * Applies partial updates from the response DTO to the entity, ignoring null values.
     *
     * @param response Response DTO containing partial updates.
     * @param entity   Entity to be updated.
     * @return Updated entity.
     */
    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    E applyPartialUpdates(S response, @MappingTarget E entity);

    /**
     * Maps a string representing the creation timestamp to a {@link Timestamp} object.
     *
     * @param createdAt String representation of the creation timestamp.
     * @return {@link Timestamp} object representing the creation timestamp.
     */
    default Timestamp mapCreatedAt(String createdAt) {
        if (createdAt == null) {
            return null;
        }
        return Timestamp.valueOf(createdAt);
    }

    /**
     * Maps a string representing the update timestamp to a {@link Timestamp} object.
     *
     * @param updatedAt String representation of the update timestamp.
     * @return {@link Timestamp} object representing the update timestamp.
     */
    default Timestamp mapUpdatedAt(String updatedAt) {
        if (updatedAt == null) {
            return null;
        }
        return Timestamp.valueOf(updatedAt);
    }
}
