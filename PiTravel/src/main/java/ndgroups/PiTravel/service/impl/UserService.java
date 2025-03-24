package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.Exception.ResourceNotFoundException;
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
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with the given id " + userId));
    }

    @Override
    public User updateUser(Integer userId, User user) {
        Optional<User> optUser = userRepository.findById(userId);
        if(optUser.isPresent()){
            User existingUser  =  optUser.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(existingUser);
        }
        throw new ResourceNotFoundException("user not found");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer userId) {
       if(!userRepository.existsById(userId)){
           throw new ResourceNotFoundException("user not found with the given id");
       }
       userRepository.deleteById(userId);
    }


    @Override
    public User getUserInfo(String email) {
        if(userRepository.existsByEmail(email)){
            return userRepository.findByEmail(email);
        }
       throw new ResourceNotFoundException("no user with the given email " + email);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}


