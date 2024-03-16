package ma.tamount.backend.web.rest;

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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Generic controller with CRUD operations for DTOs.
 *
 * @param <T>           The type of the identifier.
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
public abstract class AbstractController<T, R extends GenericRequest, D extends GenericResponse, S extends GenericService<T, R, D>> implements GenericController<T, R, D> {

    S service;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public final void setService(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<D> create(R request, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<Page<D>> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<List<D>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<D> getById(T id) {
        return null;
    }

    @Override
    public ResponseEntity<D> update(R request, BindingResult bindingResult) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(R request, BindingResult bindingResult) {
        return null;
    }

    @Override
    public void handleValidationError(BindingResult bindingResult) {

    }
}
