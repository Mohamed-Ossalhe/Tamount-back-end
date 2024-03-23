package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link PaymentHistory} entities in the database.
 *
 * <p>This repository provides methods to interact with payment history entities, such as finding payment history by
 * ID or other attributes, and retrieving payment history based on their status.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, UUID> {
}
