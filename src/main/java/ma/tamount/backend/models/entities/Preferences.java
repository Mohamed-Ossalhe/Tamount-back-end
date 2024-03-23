package ma.tamount.backend.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.tamount.backend.models.enums.PreferenceStatus;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Represents a preferences entity in the system.
 * This class includes information about a user rides preferences such as smoking, music, pets, dialog
 * and whether the preferences are saved or not.
 *
 * @author Mohamed Ossalhe
 */
@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@Table(name = "preferences")
@AllArgsConstructor
@NoArgsConstructor
public class Preferences extends AbstractEntity {
    /**
     * Represents the preference status for smoking.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PreferenceStatus smoking;

    /**
     * Represents the preference status for music.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PreferenceStatus music;

    /**
     * Represents the preference status for pets.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PreferenceStatus pets;

    /**
     * Represents the preference status for dialog.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PreferenceStatus dialog;

    /**
     * Indicates whether the preferences are saved or not.
     * This field is mapped to a database column with the constraint that it cannot be null.
     */
    @Column(nullable = false)
    private Boolean preferencesSaved;

    /**
     * Represents the user associated with these preferences.
     * This field is mapped as a lazy-loaded one-to-one relationship with the user table.
     * Deletion of associated user records triggers a cascade delete action.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
