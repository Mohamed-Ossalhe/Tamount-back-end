package ma.tamount.backend.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO class representing the response for logout.
 * Contains a success message.
 *
 * @author Mohamed Ossalhe
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogoutResponse implements Serializable {
    private String message;
}
