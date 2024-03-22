package ma.tamount.backend.web.rest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.interfaces.GenericController;
import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.interfaces.GenericResponse;
import ma.tamount.backend.interfaces.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Generic controller with CRUD operations for DTOs.
 *
 * @param <I>           The type of the identifier.
 * @param <R>  The request DTO type implementing {@link GenericRequest}.
 * @param <D> The response DTO type implementing {@link GenericResponse}.
 * @param <S>  The service type implementing {@link GenericService}.
 * @author Mohamed Ossalhe
 */
@Slf4j
@Getter
@Validated
@RestController
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractController<I, R extends GenericRequest, D extends GenericResponse, S extends GenericService<I, R, D>> implements GenericController<I, R, D> {

    private S service;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public final void setService(S service) {
        this.service = service;
    }

    /**
     * Creates a new entity based on the provided request.
     *
     * @param request       The request DTO.
     * @return ResponseEntity containing the created entity or a bad request if creation fails.
     */
    @Override
    @PostMapping
    public ResponseEntity<D> create(@Valid @RequestBody R request) {
        assert service != null;
        Optional<D> response = service.create(request);
        return response.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.badRequest().build());
    }

    /**
     * Retrieves all entities with pagination.
     *
     * @param pageable The pagination information.
     * @return ResponseEntity containing a page of entities.
     */
    @Override
    @GetMapping("/paged")
    public ResponseEntity<Page<D>> getAll(Pageable pageable) {
        assert service != null;
        return ResponseEntity.ok(service.getAll(pageable));
    }

    /**
     * Retrieves all entities.
     *
     * @return ResponseEntity containing a list of entities.
     */
    @Override
    @GetMapping
    public ResponseEntity<List<D>> getAll() {
        assert service != null;
        return ResponseEntity.ok(service.getAll());
    }

    /**
     * Retrieves an entity by its identifier.
     *
     * @param id The identifier of the entity.
     * @return ResponseEntity containing the retrieved entity or not found response if the entity does not exist.
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable I id) {
        assert service != null;
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Updates an existing entity based on the provided request.
     *
     * @param request       The request DTO.
     * @return ResponseEntity containing the updated entity or not found response if the update fails.
     */
    @Override
    @PatchMapping
    public ResponseEntity<D> update(@Valid @RequestBody R request) {
        assert service != null;
        Optional<D> updated = service.update(request);
        return updated.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Deletes an entity based on the provided request.
     *
     * @param request       The request DTO.
     * @return ResponseEntity with no content if deletion is successful, or not found response if deletion fails.
     */
    @Override
    @DeleteMapping
    public ResponseEntity<Void> delete(R request) {
        assert service != null;
        if (Boolean.TRUE.equals(service.delete(request))) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
