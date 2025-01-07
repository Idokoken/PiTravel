package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.response.ApiResponse;
import ndgroups.PiTravel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private IUserService userService;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestParam("user") User user) {
        try {
            User newUser  = userService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("user created", newUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));

        }

    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> LoginUser(@RequestParam User user) {
        try {
            User newUser  = userService.register(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("user created", newUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));

        }
    }

    //logout route
    @PostMapping("/logout")
    public  ResponseEntity<ApiResponse> logout() {
            return ResponseEntity.ok(new ApiResponse("successfully logged out", null));

    }


}
