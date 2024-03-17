package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "verification_codes")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode extends AbstractEntity {
    private Integer code;
    private Timestamp generationTime;
    private Timestamp expirationTime;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private Integer usageCount;
}
