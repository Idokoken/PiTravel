package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.Exception.AlreadyExistException;
import ndgroups.PiTravel.Exception.ResourceNotFoundException;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.request.CreateUserRequest;
import ndgroups.PiTravel.response.APIResponse;
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
    public ResponseEntity<APIResponse> createUser(@RequestBody CreateUserRequest request) {
        try {
            User user = userService.createUser(request);
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new APIResponse("user successfully created", user));
        } catch (AlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUserById(@PathVariable Integer userId) {
        try {
            User user = userService.getUserById(userId);
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new APIResponse("success", user));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new APIResponse("success", users));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<APIResponse> updateUser(@PathVariable Integer id, @RequestBody User request) {
        try {
            User user = userService.updateUser(id, request);
            return ResponseEntity.ok(new APIResponse("user successfully created", user));
        } catch (AlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<APIResponse> deleteUser(@PathVariable  Integer userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok(new APIResponse("success", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/info")
    public ResponseEntity<APIResponse> getUserInfo(@RequestParam String email) throws Exception {
        try {
            User user = userService.getUserInfo(email);
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new APIResponse("success", user));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/name")
    public ResponseEntity<APIResponse> findByUsername(@RequestParam String username) {
        try {
            List<User> user = userService.findByUsername(username);
//            UserDTO userDto = userService.convertUserToDto(user);
            return ResponseEntity.ok(new APIResponse("success", user));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

}

