package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link Location} entities in the database.
 *
 * <p>This repository provides methods to interact with Location entities, such as finding locations by
 * ID or other attributes, and add new and update existing locations.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface LocationRepository extends JpaRepository<Location, UUID> {
}
