package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.request.CreateUserRequest;

import java.util.List;


public interface IUserService {
    User createUser(CreateUserRequest request);
    User getUserById(Integer userId);
    User updateUser(Integer userId, User user);
    void deleteUser(Integer userId);
    List<User> getAllUsers();
    User getUserInfo(String email);
    List<User> findByUsername(String username);
}
