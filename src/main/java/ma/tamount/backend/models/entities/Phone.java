package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.tamount.backend.models.enums.RegionCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Represents a phone entity in the system.
 * This class includes information about a phone number such as its national number, formatted number,
 * national formatted number, international formatted number, region code and the user which belongs to.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "phone_numbers")
@AllArgsConstructor
@NoArgsConstructor
public class Phone extends AbstractEntity {
    /**
     * Represents the national number associated with a phone number.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private Integer nationalNumber;

    /**
     * Represents the formatted number of a phone number.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private String formattedNumber;

    /**
     * Represents the national formatted number of a phone number.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private String nationalFormattedNumber;

    /**
     * Represents the international formatted number of a phone number.
     * This field cannot be null.
     */
    @Column(nullable = false)
    private String internationalFormattedNumber;

    /**
     * Represents the region code associated with a phone number.
     * This field cannot be null.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RegionCode regionCode;

    /**
     * Represents the user associated with a phone number.
     * This field is fetched lazily and is subject to cascading deletion.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
