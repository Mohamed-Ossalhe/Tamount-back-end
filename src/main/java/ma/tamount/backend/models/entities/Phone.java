package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.tamount.backend.models.enums.RegionCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "phone_numbers")
@AllArgsConstructor
@NoArgsConstructor
public class Phone extends AbstractEntity {
    @Column(nullable = false)
    private Integer nationalNumber;
    @Column(nullable = false)
    private String formattedNumber;
    @Column(nullable = false)
    private String nationalFormattedNumber;
    @Column(nullable = false)
    private String internationalFormattedNumber;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RegionCode regionCode;

    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
