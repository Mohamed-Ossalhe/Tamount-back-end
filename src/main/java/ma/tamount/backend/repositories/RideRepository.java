package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link Ride} entities in the database.
 *
 * <p>This repository provides methods to interact with ride entities, such as finding rides by
 * ID or other attributes, and retrieving rides based on their status.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface RideRepository extends JpaRepository<Ride, UUID> {
}
