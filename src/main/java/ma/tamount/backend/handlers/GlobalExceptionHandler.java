package ma.tamount.backend.handlers;

import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.exceptions.ResourceAlreadyExistsException;
import ma.tamount.backend.exceptions.ResourceNotCreatedException;
import ma.tamount.backend.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for handling various exceptions in the API.
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handle MethodArgumentNotValidException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle MethodArgumentNotValidException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle MethodArgumentNotValidException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistsException(ResourceAlreadyExistsException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle MethodArgumentNotValidException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ResourceNotCreatedException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotCreatedException(ResourceNotCreatedException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.CONFLICT, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /**
     * Handle HttpMessageNotReadableException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.CONFLICT, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /**
     * Handle HttpMessageNotReadableException and return a proper API error response.
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(AuthenticationException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.UNAUTHORIZED, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
