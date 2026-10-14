package ndgroups.PiTravel.controller;

import jakarta.validation.Valid;
import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import ndgroups.PiTravel.dto.FlightDTO;
import ndgroups.PiTravel.model.Flight;
import ndgroups.PiTravel.request.FlightRequest;
import ndgroups.PiTravel.response.ApiResponseDto;
import ndgroups.PiTravel.service.Interface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${api.prefix}/flights")
public class FlightController {
    @Autowired
    private IFlightService flightService;

    @PostMapping
    public ResponseEntity<ApiResponseDto> createFlight(@Valid @RequestBody FlightRequest request){
        try {
            FlightDTO flight = flightService.createFlight(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), flight,
                            "flight successfully created"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getFlightById(@PathVariable Integer id){
        try {
            FlightDTO flight = flightService.getFlightById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flight,
                            "flight successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto> updateFlight(@Valid @RequestBody FlightRequest request,
                                                       @PathVariable Integer id){
        try {
            FlightDTO flight = flightService.updateFlight(id,request);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flight,
                            "flight successfully updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponseDto> getAllFlights(){
        try {
            List<FlightDTO> flights = flightService.getAllFlights();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flights,
                            "All flights successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }


    @GetMapping("/dates")
    public ResponseEntity<ApiResponseDto> getFlightByDepartureAndArrivalAirport(
            @RequestParam(required = false) Integer depId,
            @RequestParam(required = false) Integer arrId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size){
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<FlightDTO> flights = flightService.getFlightByDepartureAndArrivalAirport(depId,
                    arrId, pageable);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flights,
                            "flights successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/available")
    public ResponseEntity<ApiResponseDto> getAllAvailableFlights(){
        try {
            List<FlightDTO> flights = flightService.getAllAvailableFight();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flights,
                            "All Available flights successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }


    @PutMapping("/status/{id}")
    public ResponseEntity<ApiResponseDto> changeStatus(@PathVariable Integer id,
                                                       @RequestParam FLIGHT_STATUS status){
        try {
            FlightDTO flight = flightService.changeFightStatus(id, status);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), flight,
                            "flight status successfully changed"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto> deleteFlight(@PathVariable Integer id){
        try {
            flightService.deleteFlight(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), null,
                            "flight successfully deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

}
