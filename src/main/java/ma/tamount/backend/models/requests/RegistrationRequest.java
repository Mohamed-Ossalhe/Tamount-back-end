package ma.tamount.backend.models.requests;

import jakarta.validation.constraints.*;
import ma.tamount.backend.interfaces.GenericRequest;
import ma.tamount.backend.models.enums.Gender;
import org.springframework.format.annotation.DateTimeFormat;
import ma.tamount.backend.models.entities.User;
import java.time.LocalDate;

/**
 * DTO for creating or updating a {@link User} entity.
 * Represents a user request with details such as password, image, phone number,
 * email, first name, last name, gender, and address.
 *
 * @author Mohamed Ossalhe
 */
public record RegistrationRequest(

        @NotNull(message = "email is required")
        @Size(message = "email is too long", max = 80)
        @Email(message = "email is not valid")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
        String email,

        @NotNull(message = "first name is required")
        @Size(message = "first name must be at least 3 Characters", min = 3)
        @Pattern(regexp = "^[a-zA-Z]{3,}$")
        String firstName,

        @NotNull(message = "last name is required")
        @Size(message = "last name must be at least 3 Characters", min = 3)
        @Pattern(regexp = "^[a-zA-Z]{3,}$")
        String lastName,

        @NotNull(message = "birth date is required")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,

        @NotNull(message = "gender is required")
        Gender gender,

        @NotNull(message = "password is required")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
        @Size(message = "password must be at least 8 characters", min = 8)
        String password,

        PhoneRequest phoneNumber
) implements GenericRequest {
}
