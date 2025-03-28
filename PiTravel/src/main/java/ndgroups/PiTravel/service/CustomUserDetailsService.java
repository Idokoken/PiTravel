package ndgroups.PiTravel.service;


import ndgroups.PiTravel.model.CustomUserDetails;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user  = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return CustomUserDetails.buildUserDetails(user);
    }

//    public String[] getRoles(User user){
//        if (user.getRole() == null) {
//            return new String[]{"USER"};
//        }
//        return user.getRole().split(",");
//    }


}
