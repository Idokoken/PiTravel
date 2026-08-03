package ndgroups.PiTravel.service.Interface;

import jakarta.mail.MessagingException;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.request.LoginRequest;
import ndgroups.PiTravel.request.RegisterUserRequest;

import java.io.UnsupportedEncodingException;

public interface IAuthService {
    User registerUser(RegisterUserRequest request) throws MessagingException, UnsupportedEncodingException;
    User login(LoginRequest request);
}
