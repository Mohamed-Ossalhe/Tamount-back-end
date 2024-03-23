package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link Car} entities in the database.
 *
 * <p>This repository provides methods to interact with Car entities, such as finding cars by
 * ID or other attributes, and add new and update existing cars.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface CarRepository extends JpaRepository<Car, UUID> {
}
