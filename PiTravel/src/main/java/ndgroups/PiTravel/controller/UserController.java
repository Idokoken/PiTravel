package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PutMapping("/update")
    public String updateUser(@ModelAttribute User user, Model model){
//        Optional<User>optUser = userService.updateUser(user);
//        model.addAttribute("message", "user info updated successfully");
        return "redirect:/user/profile";
    }


}
