package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link Phone} entities in the database.
 *
 * <p>This repository provides methods to interact with Phone entities, such as finding phone numbers by
 * ID or other attributes, and add new and update existing phone numbers.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface PhoneRepository extends JpaRepository<Phone, UUID> {
}
