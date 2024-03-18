package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Year;

/**
 * Represents a car entity in the system.
 * This class includes information about a car such as its model, maker, color, comfort,
 * category, license plate, registration year, and the user which belongs to.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
public class Car extends AbstractEntity {
    /**
     * Represents the model of the vehicle.
     */
    @Column(nullable = false)
    private String model;

    /**
     * Represents the make of the vehicle.
     */
    @Column(nullable = false)
    private String make;

    /**
     * Represents the color of the vehicle.
     */
    @Column(nullable = false)
    private String color;

    /**
     * Represents the comfort level of the vehicle.
     */
    @Column(nullable = false)
    private String comfort;

    /**
     * Represents the category of the vehicle.
     */
    @Column(nullable = false)
    private String category;

    /**
     * Represents the license plate of the vehicle.
     */
    @Column(nullable = false)
    private String licensePlate;

    /**
     * Represents the registration year of the vehicle.
     */
    @Column(nullable = false)
    private Year registrationYear;

    /**
     * Represents the user who owns the vehicle.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
