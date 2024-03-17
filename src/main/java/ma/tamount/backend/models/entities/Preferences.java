package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.tamount.backend.models.enums.PreferenceStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@ToString
@Entity
@Builder
@Table(name = "preferences")
@AllArgsConstructor
@NoArgsConstructor
public class Preferences extends AbstractEntity {
    @Column(nullable = false)
    private PreferenceStatus smoking;
    @Column(nullable = false)
    private PreferenceStatus music;
    @Column(nullable = false)
    private PreferenceStatus pets;
    @Column(nullable = false)
    private PreferenceStatus dialog;
    @Column(nullable = false)
    private Boolean preferencesSaved;
    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
