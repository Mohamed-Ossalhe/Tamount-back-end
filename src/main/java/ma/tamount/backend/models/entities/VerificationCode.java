package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

/**
 * Represents a verification code entity in the system.
 * This class includes information about a verification code such as code, generation time, expiration time,
 * usage count, and the user which used the code.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "verification_codes")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode extends AbstractEntity {
    /**
     * the verification code
     */
    private Integer code;
    /**
     * the code generation time
     */
    private Timestamp generationTime;
    /**
     * the code expiration time
     */
    private Timestamp expirationTime;

    /**
     * the user who used the code
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    /**
     * how many times the code has been used
     */
    private Integer usageCount;
}
