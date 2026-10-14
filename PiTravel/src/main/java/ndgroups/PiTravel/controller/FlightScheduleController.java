package ndgroups.PiTravel.controller;

import jakarta.validation.Valid;
import ndgroups.PiTravel.dto.FlightScheduleDTO;
import ndgroups.PiTravel.request.FlightScheduleRequest;
import ndgroups.PiTravel.response.ApiResponseDto;
import ndgroups.PiTravel.service.Interface.IFlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${api.prefix}/flight-schedule")
public class FlightScheduleController {
    @Autowired
    private IFlightScheduleService flightScheduleService;

    @PostMapping
    public ResponseEntity<ApiResponseDto> createFlightSchedule(
            @Valid @RequestBody FlightScheduleRequest request){
        try {
            FlightScheduleDTO flightSchedule = flightScheduleService.createFlightSchedule(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), flightSchedule,
                            "Flight Schedule successfully created"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getFlightScheduleById(@PathVariable Integer id){
        try {
            FlightScheduleDTO flightSchedule = flightScheduleService.getFLightScheduleById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flightSchedule,
                            "flight Schedule Successfully Fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }


    @GetMapping
    public ResponseEntity<ApiResponseDto> getAllFlightSchedules(){
        try {
            List<FlightScheduleDTO> flightSchedules = flightScheduleService.getAllFlightSchedule();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flightSchedules,
                            "All flight Schedule Successfully Fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto> updateFlightSchedule(
            @RequestBody FlightScheduleRequest request, @PathVariable Integer id){
        try {
            FlightScheduleDTO flightSchedule = flightScheduleService.updateFlightSchedule(request, id);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), flightSchedule,
                            "Flight Schedule successfully updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getAllFlightSchedules(@PathVariable Integer id){
        try {
            flightScheduleService.deleteFlightSchedule(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), null,
                            "All flight Schedule Successfully Deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

}
