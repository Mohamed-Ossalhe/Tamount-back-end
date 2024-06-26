package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.enums.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SoftDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Collection;
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
@Entity
@SuperBuilder
@SoftDelete
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity implements UserDetails {
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
    private Integer birthYear;

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
    private boolean emailVerified = false;

    /**
     * Represents whether the user's phone number is verified.
     */
    @Column(nullable = false)
    private boolean phoneVerified = false;

    /**
     * Represents whether the user has a profile picture.
     */
    @Column(nullable = false)
    private boolean hasPicture = false;

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
    private List<Car> cars;

    /**
     * Represents the preferences of the user.
     */
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Preferences preferences;

    /**
     * Represents the list of bookings associated with the user.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Booking> bookings;

    /**
     * Represents the list of rides associated with the user.
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Ride> rides;

    /**
     * set default values before persisting the entity using @PrePersist JPA lifecycle callbacks.
     */
    @PrePersist
    protected void onMount() {
        memberSince = Timestamp.from(Instant.now());
        verificationStatus = VerificationStatus.NOT_VERIFIED;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(getRole().toString())
        );
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
