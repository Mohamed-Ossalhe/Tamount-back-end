package ma.tamount.backend.repositories;

import io.micrometer.common.lang.NonNullApi;
import ma.tamount.backend.models.entities.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository interface for accessing and managing {@link VerificationCode} entities in the database.
 *
 * <p>This repository provides methods to interact with verification code entities, such as finding verification code by
 * type or ID, and retrieving verification code based on their type.</p>
 *
 * @author Mohamed Ossalhe
 */
@Repository
@NonNullApi
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, UUID> {
}
