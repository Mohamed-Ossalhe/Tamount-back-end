package ma.tamount.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.entities.Phone;
import ma.tamount.backend.models.entities.User;
import ma.tamount.backend.models.enums.*;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) representing user-related responses.
 * This class is designed to carry user-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the user, including personal information,
 * contact details, and addressing information. It is used to transfer user data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see User
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse extends AbstractResponse {
    private String firstName;

    /**
     * Represents the last name of the user.
     */
    private String lastName;

    /**
     * Represents the email address of the user. Must be unique.
     */
    private String email;

    /**
     * Represents the password of the user.
     */
    private String password;

    /**
     * Represents the role of the user.
     */
    private Role role;

    /**
     * Represents the URL path of the user's profile picture.
     */
    private String picture;

    /**
     * Represents the birth year of the user.
     */
    private Integer birthYear;

    /**
     * Represents the birthdate of the user.
     */
    private LocalDate birthDate;

    /**
     * Represents the biography of the user.
     */
    private String bio;

    /**
     * Represents the phone number associated with the user.
     */
    private Phone phone;

    /**
     * Represents the gender of the user.
     */
    private Gender gender;

    /**
     * Represents the age of the user.
     */
    private Integer age;

    /**
     * Represents the timestamp of the user's last login.
     */
    private Timestamp lastLogin;

    /**
     * Represents the timestamp when the user became a member.
     */
    private Timestamp memberSince;

    /**
     * Represents the status of the user's ID verification.
     */
    private IdChecked idChecked;

    /**
     * Represents the type of ID verification the user underwent.
     */
    private IdCheckedType idCheckedType;

    /**
     * Represents whether the user's email address is verified.
     */
    private boolean emailVerified;

    /**
     * Represents whether the user's phone number is verified.
     */
    private boolean phoneVerified;

    /**
     * Represents whether the user has a profile picture.
     */
    private boolean hasPicture;

    /**
     * Represents the verification status of the user's account.
     */
    private VerificationStatus verificationStatus;
}
