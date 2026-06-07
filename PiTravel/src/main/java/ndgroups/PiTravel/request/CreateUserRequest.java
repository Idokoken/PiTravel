package ndgroups.PiTravel.request;

import lombok.Data;
import ndgroups.PiTravel.Enum.USER_ROLE;

@Data
public class CreateUserRequest {
    private String username;
    private String email;
    private String password;
    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;


}
