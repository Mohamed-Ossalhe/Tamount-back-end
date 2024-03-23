package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link Booking} entities in the database.
 *
 * <p>This repository provides methods to interact with ride entities, such as finding bookings by
 * ID or other attributes, and retrieving bookings based on their status.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
