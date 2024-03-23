package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link Preferences} entities in the database.
 *
 * <p>This repository provides methods to interact with Preferences entities, such as finding Preferences by
 * ID or other attributes, and add new and update existing Preferences.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface PreferencesRepository extends JpaRepository<Preferences, UUID> {
}
