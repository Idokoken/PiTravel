package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.Plane;
import ndgroups.PiTravel.response.ApiResponse;
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
    public ResponseEntity<ApiResponse> AddPlane(@RequestBody Plane plane) {
        try {
            Plane newPlane  =  planeService.addPlane(plane);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("user created", newPlane));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getOnePlane(@PathVariable Integer id) {
        try {
            Plane plane  =  planeService.getPlaneById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", plane));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updatePlane(@PathVariable Integer id, @RequestBody Plane updatePlane)  {
        try {
            Plane updatedPlane  =  planeService.updatePlane(id, updatePlane);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("plane updated", updatedPlane));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePlane( @PathVariable Integer id)  {
        try {
            planeService.deletePlane(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("plane successfully deleted", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllPlanes() {
        try {
            List<Plane> planes  =  planeService.getAllPlanes();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/available")
    public ResponseEntity<ApiResponse> getAllAvailablePlanes() {
        try {
            List<Plane> planes  =  planeService.getAllAvailablePlanes();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/name")
    public ResponseEntity<ApiResponse> getPlanesByName(@RequestParam String name) {
        try {
            List<Plane> planes  =  planeService.getPlanesByPlaneName(name);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/departureDate")
    public ResponseEntity<ApiResponse> getPlanesByDepartureDate(@RequestParam LocalDate departureDate) {
        try {
            List<Plane> planes  =  planeService.getPlanesByDepartureDate(departureDate);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/destination")
    public ResponseEntity<ApiResponse> getPlanesByDestination(@RequestParam String destination) {
        try {
            List<Plane> planes  =  planeService.getPlanesByDestination(destination);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", planes));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse> searchPlane(@RequestParam String origin, @RequestParam String destination,
                                                   @RequestParam LocalDate departureDate) {
        try {
            List<Plane>planes =  planeService.findAvailablePlanesByOriginAndDestinationAndDepartureDate(origin, destination,
                    departureDate);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("user created", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
}
