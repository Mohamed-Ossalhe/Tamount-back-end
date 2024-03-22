package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Represents a location with a city, address, and coordinates.
 * Extends AbstractEntity to inherit common properties like id and timestamps.
 *
 * @author Mohamed Ossalhe
 */

@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@Table(name = "locations")
@AllArgsConstructor
@NoArgsConstructor
public class Location extends AbstractEntity {

    /**
     * The city associated with this location.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City city;

    /**
     * The address of this location.
     */
    @Column(nullable = false)
    private String address;

    /**
     * Latitude of the location.
     */
    private Double latitude;

    /**
     * Longitude of the location.
     */
    private Double longitude;
}
