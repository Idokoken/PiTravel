package ndgroups.PiTravel.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String fistName;
    private String lastName;
    private String phoneNumber;
}
