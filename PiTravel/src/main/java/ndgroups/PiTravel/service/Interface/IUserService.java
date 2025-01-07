package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.model.User;

import java.util.List;

public interface IUserService {
    User register(User user);
    User login(User user);
    List<User> getAllUsers();
    User getUserBookingHistory(String userId);
    void deleteUser(String userId);
    User getUserById(String userId);
    User getMyInfo(String email);
}
