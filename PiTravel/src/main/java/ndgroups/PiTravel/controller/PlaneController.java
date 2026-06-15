package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.Plane;
import ndgroups.PiTravel.response.APIResponse;
import ndgroups.PiTravel.service.Interface.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/planes")
public class PlaneController {
    @Autowired
    private IPlaneService planeService;

    @PostMapping("/add")
    public ResponseEntity<APIResponse> AddPlane(@RequestBody Plane plane) {
        try {
            Plane newPlane  =  planeService.addPlane(plane);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new APIResponse("plane created", newPlane));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getOnePlane(@PathVariable Integer id) {
        try {
            Plane plane  =  planeService.getPlaneById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", plane));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllPlanes() {
        try {
            List<Plane> planes  =  planeService.getAllPlanes();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> updatePlane(@PathVariable Integer id, @RequestBody Plane updatePlane)  {
        try {
            Plane updatedPlane  =  planeService.updatePlane(id, updatePlane);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new APIResponse("plane updated", updatedPlane));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deletePlane(@PathVariable Integer id)  {
        try {
            planeService.deletePlane(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("plane successfully deleted", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/available")
    public ResponseEntity<APIResponse> getAllAvailablePlanes() {
        try {
            List<Plane> planes  =  planeService.getAllAvailablePlanes();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/name")
    public ResponseEntity<APIResponse> getPlanesByName(@RequestParam String name) {
        try {
            List<Plane> planes  =  planeService.getPlanesByPlaneName(name);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/departureDate")
    public ResponseEntity<APIResponse> getPlanesByDepartureDate(@RequestParam LocalDate departureDate) {
        try {
            List<Plane> planes  =  planeService.getPlanesByDepartureDate(departureDate);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/destination")
    public ResponseEntity<APIResponse> getPlanesByDestination(@RequestParam String destination) {
        try {
            List<Plane> planes  =  planeService.getPlanesByDestination(destination);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<APIResponse> searchPlane(@RequestParam String origin, @RequestParam String destination,
                                                   @RequestParam LocalDate departureDate) {
        try {
            List<Plane>planes =  planeService.findAvailablePlanesByOriginAndDestinationAndDepartureDate(origin, destination,
                    departureDate);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }
}
