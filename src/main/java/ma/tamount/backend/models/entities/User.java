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
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = false)
    private String picture;
    @Column()
    private Year birthYear;
    @Column()
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;
    @Column()
    private String bio;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Phone phone;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column()
    private Integer age;
    @Column(nullable = false)
    private Timestamp lastLogin;
    @Column(nullable = false)
    private LocalDate memberSince;
    @Column()
    @Enumerated(EnumType.STRING)
    private IdChecked idChecked;
    @Column()
    @Enumerated(EnumType.STRING)
    private IdCheckedType idCheckedType;
    @Column(nullable = false)
    private boolean emailVerified;
    @Column(nullable = false)
    private boolean phoneVerified;
    @Column(nullable = false)
    private boolean hasPicture;
    @Column()
    @Enumerated(EnumType.STRING)
    private VerificationStatus verificationStatus;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Car> cars;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Preferences preferences;
}
