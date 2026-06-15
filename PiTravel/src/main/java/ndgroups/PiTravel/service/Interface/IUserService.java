package ndgroups.PiTravel.service.Interface;

import jakarta.mail.MessagingException;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.request.CreateUserRequest;
import ndgroups.PiTravel.request.LoginRequest;
import ndgroups.PiTravel.request.RegisterUserRequest;

import java.io.UnsupportedEncodingException;
import java.util.List;


public interface IUserService {
    User registerUser(RegisterUserRequest request) throws MessagingException, UnsupportedEncodingException;
    User login(LoginRequest request);
    User createUser(CreateUserRequest request);
    User getUserById(Integer userId);
    User updateUser(Integer userId, User user);
    void deleteUser(Integer userId);
    List<User> getAllUsers();
    User getUserInfo(String email) throws Exception;
    List<User> findByUsername(String username);

    public User findUserByJwtToken(String jwt) throws Exception;
    public User findUserByEmail(String email) throws Exception;
    User getUserByUserId(Integer id) throws Exception;

    boolean changePassword(String email, String oldPassword, String newPassword);
    boolean verifyUserByToken(String token);
    String leaveAccount(String email, String password);
    boolean checkEmailExists(String email);
    boolean isEmailVerified(String email);
    void sendPasswordResetOtp(String email);
    void resetPassword(String email, String otp, String newPassword);



}


