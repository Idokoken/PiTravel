package ndgroups.PiTravel.response;

import lombok.Data;
import ndgroups.PiTravel.Enum.USER_ROLE;

//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;
}


