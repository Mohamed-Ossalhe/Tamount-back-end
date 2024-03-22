package ma.tamount.backend.interfaces;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Generic controller with CRUD operations for DTOs.
 *
 * @param <T> The type of the identifier.
 * @param <R>> The request DTO type.
 * @param <S> The response DTO type.
 * @author Mohamed Ossalhe
 */
public interface GenericController<T, R extends GenericRequest, S extends GenericResponse> {

    /**
     * Creates a new entity based on the provided request.
     *
     * @param request       The request DTO.
     * @return ResponseEntity containing the created entity or a bad request if creation fails.
     */
    ResponseEntity<S> create(@Valid @RequestBody R request);

    /**
     * Retrieves all entities with pagination.
     *
     * @param pageable The pagination information.
     * @return ResponseEntity containing a page of entities.
     */
    ResponseEntity<Page<S>> getAll(Pageable pageable);

    /**
     * Retrieves all entities.
     *
     * @return ResponseEntity containing a list of entities.
     */
    ResponseEntity<List<S>> getAll();

    /**
     * Retrieves an entity by its identifier.
     *
     * @param id The identifier of the entity.
     * @return ResponseEntity containing the retrieved entity or not found response if the entity does not exist.
     */
    ResponseEntity<S> getById(@Valid @PathVariable("id") T id);

    /**
     * Updates an existing entity based on the provided request.
     *
     * @param request       The request DTO.
     * @return ResponseEntity containing the updated entity or not found response if the update fails.
     */
    ResponseEntity<S> update(@Valid @RequestBody R request);

    /**
     * Deletes an entity based on the provided request.
     *
     * @param request       The request DTO.
     * @return ResponseEntity with no content if deletion is successful, or not found response if deletion fails.
     */
    ResponseEntity<Void> delete(@Valid @RequestBody R request);
}
