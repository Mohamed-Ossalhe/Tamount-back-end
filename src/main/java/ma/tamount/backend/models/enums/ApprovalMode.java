package ma.tamount.backend.models.enums;

/**
 * Enumeration representing approval modes for a ride.
 * <p>
 * This enum defines two approval modes: {@code MANUAL} and {@code INSTANT}.
 * <ul>
 * <li>{@code MANUAL}: Represents manual approval mode where driver approval is required.</li>
 * <li>{@code INSTANT}: Represents instant approval mode where driver approval is not required.</li>
 * </ul>
 *
 * @author Mohamed Ossalhe
 */
public enum ApprovalMode {
    /**
     * Manual approval mode.
     * <p>
     * In this mode, approval is required to be provided manually by a driver.
     */
    MANUAL,

    /**
     * Instant approval mode.
     * <p>
     * In this mode, approval is granted automatically without driver approval.
     */
    INSTANT
}

