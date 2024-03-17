package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Year;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
public class Car extends AbstractEntity {
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String make;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String comfort;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String licensePlate;
    @Column(nullable = false)
    private Year registrationYear;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
