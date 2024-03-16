package ma.tamount.backend.interfaces;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Generic service interface with common CRUD (Create, Read, Update, Delete) operations.
 *
 * @param <T>  The type of the unique identifier.
 * @param <R> The request DTO type.
 * @param <S> The response DTO type.
 * @author Mohamed Ossalhe
 */
public interface GenericService<T, R extends GenericRequest, S extends GenericResponse> {
    /**
     * Retrieves a list of all entities.
     *
     * @return List of response DTOs representing all entities.
     */
    List<S> getAll();

    /**
     * Retrieves all entities in a paginated form.
     *
     * @param pageable Pagination information.
     * @return Page of response DTOs.
     */
    Page<S> getAll(Pageable pageable);

    /**
     * Creates a new entity based on the provided request DTO.
     *
     * @param request DTO containing data for entity creation.
     * @return Optional containing the response DTO of the created entity.
     */
    Optional<S> create(@Valid R request);

    /**
     * Updates an existing entity based on the provided response DTO.
     *
     * @param request DTO containing updated data.
     * @return Optional containing the response DTO of the updated entity.
     */
    Optional<S> update(@Valid R request);

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id Unique identifier of the entity.
     * @return Optional containing the response DTO of the found entity.
     */
    Optional<S> getById(T id);

    /**
     * Deletes an entity based on the provided response DTO.
     *
     * @param request DTO containing data for entity deletion.
     * @return Boolean indicating the success of the deletion operation.
     */
    Boolean delete(@Valid R request);
}