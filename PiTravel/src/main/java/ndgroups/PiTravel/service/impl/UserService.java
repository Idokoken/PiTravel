package ndgroups.PiTravel.service.impl;

import com.ndgroups.Ahom.dto.UserDTO;
import com.ndgroups.Ahom.utils.JWTUtils;
import com.ndgroups.Ahom.utils.Utils;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.repository.UserRepository;
import ndgroups.PiTravel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;



    @Override
    public User register(User user) {
        return null;
//        User response = new User();
//        try {
//            if(user.getRole() == null || user.getRole().isBlank()){
//                user.setRole("USER");
//            }
//            if (userRepository.existsByEmail(user.getEmail())){
//                throw new OurException(user.getEmail() + "Already Exist");
//            }
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            User saveUser = userRepository.save(user);
//            UserDTO userDTO = Utils.mapUserEntityToUserDTO(saveUser);
//            response.setStatusCode(200);
//            response.setUser(userDTO);
//
//        }catch (OurException e){
//            response.setStatusCode(400);
//            response.setMessage(e.getMessage());
//        }
//        catch (Exception e){
//            response.setStatusCode(500);
//            response.setMessage("Error occurred during user registration" + e.getMessage());
//        }
//        return response;
    }

    @Override
    public User login(User user) {
        return  null;
//        User response = new User();
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
//                    loginRequest.getPassword()));
//        var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new
//                    OurException("user not found"));
//        var token = jwtUtils.generateToken(user);
//            response.setStatusCode(200);
//            response.setToken(token);
//            response.setRole(user.getRole());
//            response.setExpirationTime("7 Days");
//            response.setMessage("successful");
//        }catch (OurException e){
//            response.setStatusCode(400);
//            response.setMessage(e.getMessage());
//        }
//        catch (Exception e){
//            response.setStatusCode(500);
//            response.setMessage("Error occurred during user login" + e.getMessage());
//        }
//        return response;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserBookingHistory(String userId) {
        return null;
//        User response = new User();
//        try {
//            User user = userRepository.findById(Integer.valueOf(userId))
//                    .orElseThrow(() -> new OurException("user not found"));
//            UserDTO userDTO = Utils.mapUserEntityToUserDTOPlusUserBookingsAndRooms(user);
//            response.setStatusCode(200);
//            response.setMessage("successful");
//            response.setUser(userDTO);
//
//        }catch (OurException e){
//            response.setStatusCode(400);
//            response.setMessage("Error getting user booking history " + e.getMessage());
//        }
//        catch (Exception e){
//            response.setStatusCode(500);
//            response.setMessage("Error getting user booking history " + e.getMessage());
//        }
//        return response;
    }

    @Override
    public void deleteUser(String userId) {

//        User response = new User();
//        try {
//            User user = userRepository.findById(Integer.valueOf(userId))
//                    .orElseThrow(() -> new OurException("user not found"));
//            userRepository.delete(user);
//            response.setStatusCode(200);
//            response.setMessage("successful");
//        }catch (OurException e){
//            response.setStatusCode(400);
//            response.setMessage(e.getMessage());
//        }
//        catch (Exception e){
//            response.setStatusCode(500);
//            response.setMessage("Error deleting user " + e.getMessage());
//        }
//        return response;
    }

    @Override
    public User getUserById(String userId) {
        return null;
//        User response = new User();
//        try {
//            User user = userRepository.findById(Integer.valueOf(userId))
//                    .orElseThrow(() -> new OurException("user not found"));
//            UserDTO userDTO = Utils.mapUserEntityToUserDTO(user);
//            response.setStatusCode(200);
//            response.setMessage("successful");
//            response.setUser(userDTO);
//        }catch (OurException e){
//            response.setStatusCode(400);
//            response.setMessage(e.getMessage());
//        }
//        catch (Exception e){
//            response.setStatusCode(500);
//            response.setMessage("Error getting user " + e.getMessage());
//        }
//        return response;
    }

    @Override
    public User getMyInfo(String email) {
        return null;
//        User response = new User();
//        try {
//            User user = userRepository.findByEmail(email)
//                    .orElseThrow(() -> new OurException("user not found"));
//            UserDTO userDTO = Utils.mapUserEntityToUserDTO(user);
//            response.setStatusCode(200);
//            response.setMessage("successful");
//            response.setUser(userDTO);
//        }catch (OurException e){
//            response.setStatusCode(400);
//            response.setMessage(e.getMessage());
//        }
//        catch (Exception e){
//            response.setStatusCode(500);
//            response.setMessage("Error getting user info " + e.getMessage());
//        }
//        return response;
    }
}

