package ndgroups.PiTravel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String getMessage(){
        String message = "Welcome to Pitravel Airway system";
        return message;
    }

    @GetMapping("/test")
    public String getMessage2(){
        String message = "Welcome to Pitravel Airway system Test";
        return message;
    }


}
