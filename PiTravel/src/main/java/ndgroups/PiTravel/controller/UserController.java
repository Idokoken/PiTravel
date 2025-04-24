package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.Exception.AlreadyExistException;
import ndgroups.PiTravel.Exception.ResourceNotFoundException;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.request.CreateUserRequest;
import ndgroups.PiTravel.response.ApiResponse;
import ndgroups.PiTravel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("${api.prefix}/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest request) {
        try {
            User user = userService.createUser(request);
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("user successfully created", user));
        } catch (AlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Integer userId) {
        try {
            User user = userService.getUserById(userId);
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("success", user));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("success", users));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable Integer id, @RequestBody User request) {
        try {
            User user = userService.updateUser(id, request);
            return ResponseEntity.ok(new ApiResponse("user successfully created", user));
        } catch (AlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable  Integer userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok(new ApiResponse("success", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/info")
    public ResponseEntity<ApiResponse> getUserInfo(@RequestParam String email) {
        try {
            User user = userService.getUserInfo(email);
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("success", user));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/name")
    public ResponseEntity<ApiResponse> findByUsername(@RequestParam String username) {
        try {
            List<User> user = userService.findByUsername(username);
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new ApiResponse("success", user));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

}

