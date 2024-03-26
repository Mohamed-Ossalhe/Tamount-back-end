package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.enums.ApprovalMode;

import java.sql.Timestamp;

/**
 * Represents a ride entity in the system.
 * This class includes information about a ride such departure location, arrival location, departure time, approval mode,
 * is comfortable, womenOnly,  seats, route_id, and vehicle_id.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@Table(name = "rides")
@AllArgsConstructor
@NoArgsConstructor
public class Ride extends AbstractEntity {

    /**
     * The departure location of the ride.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Location departure;

    /**
     * The arrival location of the ride.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Location arrival;

    /**
     * The departure time of the ride.
     */
    @Column(nullable = false)
    private Timestamp departureTime;

    /**
     * The approval mode of the ride.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ApprovalMode approvalMode;

    /**
     * Indicates whether the ride offers comfort amenities.
     */
    @Column(nullable = false)
    private boolean isComfort;

    /**
     * Indicates whether the ride is cancelled or not.
     */
    @Column(nullable = false)
    private boolean isCancelled = false;

    /**
     * Indicates whether the ride is for women only.
     */
    @Column(nullable = false)
    private boolean womenOnly;

    /**
     * The number of available seats in the ride.
     */
    @Column(nullable = false)
    private Integer seats;

    /**
     * The price of the trip.
     */
    @Column(nullable = false)
    private Integer price;

    /**
     * The identifier of the route associated with the ride.
     */
    @Column(nullable = false)
    private String routeId;

    /**
     * The user associated with the ride.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    /**
     * The vehicle associated with the ride.
     */
    @OneToOne(fetch = FetchType.LAZY)
    private Car vehicle;
}

