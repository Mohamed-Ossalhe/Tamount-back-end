package ma.tamount.backend.services.implementation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.exceptions.ResourceNotCreatedException;
import ma.tamount.backend.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

/**
 * Generic service implementation with common CRUD operations.
 *
 * @param <I>        The type of the unique identifier.
 * @param <R>        The request DTO type.
 * @param <S>        The response DTO type.
 * @param <E>     The entity type.
 * @param <P> The repository type extending JpaRepository<Entity, UUID>.
 * @param <M>     The mapper type implementing _Mapper<Req, Res, Entity>.
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractService<I, R extends GenericRequest, S extends GenericResponse, E extends GenericEntity<I>, P extends JpaRepository<E, I>, M extends GenericMapper<I, R, S, E>> implements GenericService<I, R, S> {

    private M mapper;
    private P repository;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public void setRepository(P repository) {
        this.repository = repository;
    }

    /**
     * Retrieves a list of all entities.
     *
     * @return List of response DTOs representing all entities.
     */
    @Override
    public List<S> getAll() {
        assertMapperAndRepositoryNotNull();
        return mapper.toResponse(
                repository.findAll()
        );
    }

    /**
     * Retrieves all entities in a paginated form.
     *
     * @param pageable Pagination information.
     * @return Page of response DTOs.
     */
    @Override
    public Page<S> getAll(Pageable pageable) {
        assertMapperAndRepositoryNotNull();
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    /**
     * Creates a new entity based on the provided request DTO.
     *
     * @param request DTO containing data for entity creation.
     * @return Optional containing the response DTO of the created entity.
     */
    @Override
    public Optional<S> create(@Valid R request) {
        assertMapperAndRepositoryNotNull();
        E entityToCreate = mapper.toEntityFromRequest(request);
        try {
            E createdEntity = repository.saveAndFlush(entityToCreate);
            return Optional.of(mapper.toResponse(createdEntity));
        } catch (Exception e) {
            log.error("Error while creating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    /**
     * Updates an existing entity based on the provided response DTO.
     *
     * @param request DTO containing updated data.
     * @return Optional containing the response DTO of the updated entity.
     */
    @Override
    public Optional<S> update(@Valid R request) {
        assertMapperAndRepositoryNotNull();
        E entityToUpdate = mapper.toEntityFromRequest(request);
        try {
            E updatedEntity = repository.saveAndFlush(entityToUpdate);
            return Optional.of(mapper.toResponse(updatedEntity));
        } catch (Exception e) {
            log.error("Error while updating entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
    }

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id Unique identifier of the entity.
     * @return Optional containing the response DTO of the found entity.
     */
    @Override
    public Optional<S> getById(I id) {
        assertMapperAndRepositoryNotNull();
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    /**
     * Deletes an entity based on the provided response DTO.
     *
     * @param request DTO containing data for entity deletion.
     * @return Boolean indicating the success of the deletion operation.
     */
    @Override
    public Boolean delete(@Valid R request) {
        assertMapperAndRepositoryNotNull();
        E entityToDelete = mapper.toEntityFromRequest(request);
        if (!repository.existsById(entityToDelete.getId())) {
            return false;
        }
        try {
            repository.delete(entityToDelete);
        } catch (Exception e) {
            log.error("Error while deleting entity", e);
            throw new ResourceNotCreatedException(e.getMessage());
        }
        return true;
    }

    public void assertMapperAndRepositoryNotNull() {
        assert mapper != null;
        assert repository != null;
    }
}
