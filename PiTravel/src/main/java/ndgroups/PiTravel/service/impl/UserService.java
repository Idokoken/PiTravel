package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.dto.UserDTO;
import ndgroups.PiTravel.Exception.AlreadyExistException;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.repository.UserRepository;
import ndgroups.PiTravel.request.CreateUserRequest;
import ndgroups.PiTravel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;;

@Service
public class UserService implements IUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public User createUser(CreateUserRequest request) {
        return Optional.of(request)
                .filter(user -> !userRepository.existsByEmail(request.getEmail()))
                .map(req -> {
                    User user = new User();
                    user.setUsername(request.getUsername());
                    user.setEmail(request.getEmail());
                    user.setPassword(passwordEncoder.encode(request.getPassword()));
                    return userRepository.save(user);
                }).orElseThrow(() -> new AlreadyExistException(request.getEmail() + " already exist"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO convertUserToDto(User user) {
        return null;
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
    public void deleteUser(Integer userId) {

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

    @Override
    public User getUserById(Integer userId) {
        return null;
    }



}


