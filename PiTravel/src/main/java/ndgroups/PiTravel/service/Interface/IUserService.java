package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.dto.UserDTO;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.request.CreateUserRequest;
import ndgroups.PiTravel.request.UpdateUserRequest;

import java.util.List;

public interface IUserService {
    User login(User user);
    User getUserBookingHistory(String userId);
    User getMyInfo(String email);
    User getUserById(Integer userId);
    User createUser(CreateUserRequest request);
    User updateUser(UpdateUserRequest request, Integer userId);
    void deleteUser(Integer userId);
    List<User> getAllUsers();
    UserDTO convertUserToDto(User user);
}
