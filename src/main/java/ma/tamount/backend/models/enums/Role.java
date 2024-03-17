package ma.tamount.backend.models.enums;

/**
 * Enumeration representing different roles in the system.
 * <p>
 * This enum defines two roles: USER and ADMIN.
 * Users can have either of these roles, which determine their permissions and privileges within the system.
 *
 * @author Mohamed Ossalhe
 */
public enum Role {
    /**
     * Represents a regular user role.
     * <p>
     * Users with this role have limited permissions and privileges compared to administrators.
     */
    USER,

    /**
     * Represents an administrator role.
     * <p>
     * Users with this role have elevated permissions and privileges within the system.
     * They can perform administrative tasks such as managing users, configuring system settings, etc.
     */
    ADMIN
}

