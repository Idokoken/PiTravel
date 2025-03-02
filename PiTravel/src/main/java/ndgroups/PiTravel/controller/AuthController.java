package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.CustomUserDetails;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.request.CreateUserRequest;
import ndgroups.PiTravel.request.LoginRequest;
import ndgroups.PiTravel.response.ApiResponse;
import ndgroups.PiTravel.response.JwtResponse;
import ndgroups.PiTravel.security.JwtService;
import ndgroups.PiTravel.service.CustomUserDetailsService;
import ndgroups.PiTravel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

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

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> LoginUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(),
                            loginRequest.password()));
//            if(authentication.isAuthenticated()){
//                return jwtService.generateToken(customUserDetailsService.loadUserByUsername(
//                        loginRequest.email()));
//            }

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtService.generateToken(authentication);
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            JwtResponse jwtResponse = new JwtResponse(userDetails.getId(), jwt);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("login successful", jwtResponse));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    //logout route
    @PostMapping("/logout")
    public  ResponseEntity<ApiResponse> logout() {
            return ResponseEntity.ok(new ApiResponse("successfully logged out", null));

    }


}
