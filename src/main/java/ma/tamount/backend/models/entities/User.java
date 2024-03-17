package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.tamount.backend.models.enums.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SoftDelete;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

/**
 * Represents a user entity in the system.
 * This class includes information about a user such as he's first and last name, email, password, role,
 * picture, birth year,  full birthdate, bio, phone, gender, age, last login date and time, member since date and time
 * is his ID checked, ID checked type (License/Identity), is email verified, phone verified, has a picture and
 * verification status.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@Builder
@SoftDelete
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {
    /**
     * Represents the first name of the user.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * Represents the last name of the user.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * Represents the email address of the user. Must be unique.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Represents the password of the user.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Represents the role of the user.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Represents the URL path of the user's profile picture.
     */
    @Column(nullable = false)
    private String picture;

    /**
     * Represents the birth year of the user.
     */
    @Column()
    private Year birthYear;

    /**
     * Represents the birthdate of the user.
     */
    @Column()
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    /**
     * Represents the biography of the user.
     */
    @Column()
    private String bio;

    /**
     * Represents the phone number associated with the user.
     */
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Phone phone;

    /**
     * Represents the gender of the user.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * Represents the age of the user.
     */
    @Column()
    private Integer age;

    /**
     * Represents the timestamp of the user's last login.
     */
    @Column(nullable = false)
    private Timestamp lastLogin;

    /**
     * Represents the timestamp when the user became a member.
     */
    @Column(nullable = false)
    private Timestamp memberSince;

    /**
     * Represents the status of the user's ID verification.
     */
    @Column()
    @Enumerated(EnumType.STRING)
    private IdChecked idChecked;

    /**
     * Represents the type of ID verification the user underwent.
     */
    @Column()
    @Enumerated(EnumType.STRING)
    private IdCheckedType idCheckedType;

    /**
     * Represents whether the user's email address is verified.
     */
    @Column(nullable = false)
    private boolean emailVerified;

    /**
     * Represents whether the user's phone number is verified.
     */
    @Column(nullable = false)
    private boolean phoneVerified;

    /**
     * Represents whether the user has a profile picture.
     */
    @Column(nullable = false)
    private boolean hasPicture;

    /**
     * Represents the verification status of the user's account.
     */
    @Column()
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;

    /**
     * Represents the list of cars associated with the user.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Car> cars;

    /**
     * Represents the preferences of the user.
     */
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Preferences preferences;
}
