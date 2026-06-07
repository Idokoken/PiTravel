package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.Enum.USER_ROLE;
import ndgroups.PiTravel.config.JwtProvider;
import ndgroups.PiTravel.emailService.EmailService;
import ndgroups.PiTravel.model.Cart;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.repository.CartRepository;
import ndgroups.PiTravel.repository.UserRepository;
import ndgroups.PiTravel.request.CreateUserRequest;
import ndgroups.PiTravel.request.LoginRequest;
import ndgroups.PiTravel.response.ApiResponse;
import ndgroups.PiTravel.response.AuthResponse;
import ndgroups.PiTravel.service.CustomUserDetailsService;
import ndgroups.PiTravel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody CreateUserRequest user) {
        try {
            User newUser  = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("user created", newUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse>registerUser(@RequestBody User user) throws Exception {
        User isUserExist = userRepository.findByEmail(user.getEmail());
        if(isUserExist!= null){
            throw new Exception("email already in use");
        }
        User createdUser = new User();
        createdUser.setUsername(user.getUsername());
        createdUser.setEmail(user.getEmail());
        createdUser.setRole(user.getRole());
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User saveUser = userRepository.save(createdUser);

        Cart cart = new Cart();
        cart.setUser(saveUser);
        cartRepository.save(cart);

        // Send Notification email after successful account creation
        emailService.sendAccountCreationNotificationEmail(
                saveUser.getEmail(),
                user.getUsername()
        );

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),
                user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse response = new AuthResponse();
        response.setJwt(jwt);
        response.setMessage("registration successful");
        response.setRole(saveUser.getRole());
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse>loginUser(@RequestBody LoginRequest request){
        String username = request.getEmail();
        String password = request.getPassword();
        Authentication authentication = authenticate(username, password);

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String role = authorities.isEmpty()?null:authorities.iterator().next().getAuthority();

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse response = new AuthResponse();
        response.setJwt(jwt);
        response.setMessage("login successful");
        response.setRole(USER_ROLE.valueOf(role));
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    //logout route
    @PostMapping("/logout")
    public  ResponseEntity<ApiResponse> logout() {
        return ResponseEntity.ok(new ApiResponse(
                "successfully logged out", null));
    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        if(userDetails == null){
            throw new BadCredentialsException("invalid email...");
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("invalid password...");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());
    }


}
