package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link City} entities in the database.
 *
 * <p>This repository provides methods to interact with City entities, such as finding cities by
 * ID or other attributes, and add new and update existing cities.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface CityRepository extends JpaRepository<City, UUID> {
}
