package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.enums.RegionCode;

/**
 * Represents a city entity in the system.
 * This class includes information about a city such as city name and country code it belongs to.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City extends AbstractEntity {
    /**
     * Represents the name of the city. This field cannot be null.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Represents the city's country code which the city belongs to. This field cannot be null.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RegionCode country;
}
