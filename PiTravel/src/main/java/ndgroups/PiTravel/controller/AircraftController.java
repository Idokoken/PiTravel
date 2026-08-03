package ndgroups.PiTravel.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.request.AircraftRequest;
import ndgroups.PiTravel.response.ApiResponseDto;
import ndgroups.PiTravel.service.Interface.IAircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/aircraft")
@Tag(name = "aircraft", description = "Aircraft management")
public class AircraftController {
    @Autowired
    private IAircraftService aircraftService;


    @PostMapping("/add")
    @Operation(summary = "Create new Aircraft")
    public ResponseEntity<ApiResponseDto> AddAircraft(@Valid  @RequestBody AircraftRequest request) {
        try {
            AircraftDTO newAircraft =  aircraftService.addAircraft(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), newAircraft,
                            "aircraft created"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Aircraft Detail")
    public ResponseEntity<ApiResponseDto> getOneAircraft(@PathVariable Integer id) {
        try {
            AircraftDTO aircraft =  aircraftService.getAircraftById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), aircraft,
                    "aircraft created"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/all")
    @Operation(summary = "Get All Aircraft Details")
    public ResponseEntity<ApiResponseDto> getAllAircraft() {
        try {
            List<AircraftDTO> aircrafts =  aircraftService.getAllAircraft();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), aircrafts,
                            "successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Aircraft Detail")
    public ResponseEntity<ApiResponseDto> updateAircraft(@PathVariable Integer id,
                                                                   @Valid @RequestBody AircraftRequest request)  {
        try {
            AircraftDTO updatedAircraft =  aircraftService.updateAircraft(id, request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(),
                            updatedAircraft, "aircraft updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Aircraft")
    public ResponseEntity<ApiResponseDto<?>> deleteAircraft(@PathVariable Integer id)  {
        try {
            aircraftService.deleteAircraft(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(),
                            null, "aircraft successfully deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

//    @GetMapping("/available")
//    @Operation(summary = "Get list of all available Aircraft/Flight")
//    public ResponseEntity<ApiResponseDto> getAllAvailableAircraft() {
//        try {
//            List<AircraftDTO> aircrafts =  aircraftService.getAllAvailableAircraft();
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), aircrafts,
//                            "successful"));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                            null, e.getMessage()));
//        }
//    }

    @GetMapping("/name")
    @Operation(summary = "Get Aircraft Detail By the Aircraft name")
    public ResponseEntity<ApiResponseDto> getAircraftByName(@RequestParam String name) {
        try {
            List<AircraftDTO> aircrafts =  aircraftService.getAircraftByAircraftName(name);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), aircrafts,
                            "successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

//    @GetMapping("/departureDate")
//    @Operation(summary = "Get list Aircraft by departure date")
//    public ResponseEntity<ApiResponseDto> getAircraftByDepartureDate(
//            @RequestParam LocalDate departureDate) {
//        try {
//            List<AircraftDTO> aircrafts =  aircraftService.getAircraftByDepartureDate(departureDate);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), aircrafts,
//                            "successful"));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                            null, e.getMessage()));
//        }
//    }

//    @GetMapping("/destination")
//    @Operation(summary = "Get list Aircraft by destination or location it is going")
//    public ResponseEntity<ApiResponseDto> getAircraftByDestination(
//            @RequestParam String destination) {
//        try {
//            List<AircraftDTO> aircrafts =  aircraftService.getAircraftByDestination(destination);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), aircrafts,
//                            "successful"));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                            null, e.getMessage()));
//        }
//    }

//    @GetMapping("/search")
//    @Operation(summary = "Get list of Aircraft by origin or destination or it's departure date")
//    public ResponseEntity<ApiResponseDto> searchAircraft(@RequestParam String origin,
//                                                                      @RequestParam String destination,
//                                                                      @RequestParam LocalDate departureDate) {
//        try {
//            List<AircraftDTO> aircrafts =  aircraftService.findAvailableAircraftByOriginAndDestinationAndDepartureDate(
//                    origin, destination, departureDate);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(new ApiResponseDto<>(true,HttpStatus.OK.value(), aircrafts,
//                            "successful"));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
//                            null, e.getMessage()));
//        }
//    }





}
