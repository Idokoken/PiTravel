package ndgroups.PiTravel.controller;

import jakarta.validation.Valid;
import ndgroups.PiTravel.dto.FlightInstanceDTO;
import ndgroups.PiTravel.request.FlightInstanceRequest;
import ndgroups.PiTravel.response.ApiResponseDto;
import ndgroups.PiTravel.service.Interface.IFlightInstanceService;
import ndgroups.PiTravel.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/${api.prefix}/flights-instances")
public class FlightInstanceController {
    @Autowired
    private IFlightInstanceService flightInstanceService;
    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<ApiResponseDto> createFlightInstance(
            @Valid @RequestBody FlightInstanceRequest request){
        try {
            FlightInstanceDTO flightInstance = flightInstanceService.createFlightInstance(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), flightInstance,
                            "flight Instance successfully created"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getFlightInstanceById(@PathVariable Integer id){
        try {
            FlightInstanceDTO flightInstance = flightInstanceService.getFlightInstanceById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flightInstance,
                            "flight Instance successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto> updateFlightInstance(
            @PathVariable Integer id,
            @RequestBody FlightInstanceRequest request){
        try {
            FlightInstanceDTO flightInstance = flightInstanceService.getFlightInstanceById(id);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), flightInstance,
                            "flight Instance successfully updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto> deleteFlightInstance(@PathVariable Integer id){
        try {
            flightInstanceService.deleteFlightInstance(id);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), null,
                            "flight Instance successfully deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

//    @GetMapping
//    public ResponseEntity<ApiResponseDto> getFlightInstances(
//            Pageable pageable,
//            @RequestParam(required = false) Integer departureAirportId,
//            @RequestParam(required = false) Integer arrivalAirportId,
//            @RequestParam(required = false) Integer flightId,
//            @RequestParam(required = false) LocalDate onDate){
//        try {
//            Page<FlightInstanceDTO> flightInstances = flightInstanceService.getFlightInstances(pageable,
//                    departureAirportId, arrivalAirportId, flightId, onDate);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flightInstances,
//                            "flight Instances successfully fetched"));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
//                            null, e.getMessage()));
//        }
//    }



}
