package ndgroups.PiTravel.service.Interface;



import ndgroups.PiTravel.dto.UserDTO;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.request.CreateUserRequest;

import java.util.List;


public interface IUserService {
    User getUserBookingHistory(String userId);
    User getMyInfo(String email);
    User getUserById(Integer userId);
    User createUser(CreateUserRequest request);
    void deleteUser(Integer userId);
    List<User> getAllUsers();
    UserDTO convertUserToDto(User user);
}
