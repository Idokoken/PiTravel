package ndgroups.PiTravel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ndgroups.PiTravel.Enum.USER_ROLE;

import java.time.LocalDateTime;


@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private USER_ROLE role;
    private String profilePicture;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}