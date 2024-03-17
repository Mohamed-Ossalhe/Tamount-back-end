package ma.tamount.backend.services.implementation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
 * @param <T>        The type of the unique identifier.
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
public abstract class AbstractService<T, R extends GenericRequest, S extends GenericResponse, E extends GenericEntity<T>, P extends JpaRepository<E, T>, M extends GenericMapper<T, R, S, E>> implements GenericService<T, R, S> {

    M mapper;
    P repository;

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

    @Override
    public List<S> getAll() {
        return List.of();
    }

    @Override
    public Page<S> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<S> create(R request) {
        return Optional.empty();
    }

    @Override
    public Optional<S> update(R request) {
        return Optional.empty();
    }

    @Override
    public Optional<S> getById(T id) {
        return Optional.empty();
    }

    @Override
    public Boolean delete(R request) {
        return false;
    }
}
