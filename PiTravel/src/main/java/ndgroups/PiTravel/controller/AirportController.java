package ndgroups.PiTravel.controller;

import jakarta.validation.Valid;
import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.request.AirportRequest;
import ndgroups.PiTravel.response.ApiResponseDto;
import ndgroups.PiTravel.service.Interface.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${api.prefix}/airport")
public class AirportController {
    @Autowired
    private IAirportService airportService;

    @PostMapping
    public ResponseEntity<ApiResponseDto>createAirport( @Valid @RequestBody AirportRequest request){
        try {
            AirportDTO airport = airportService.createAirport(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), airport,
                            "airport created successfully"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto>getAirportById(@PathVariable Integer id){
        try {
            AirportDTO airport = airportService.getAirportById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), airport,
                            "airport successfully fetched"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto>getAllAirport(){
        try {
            List<AirportDTO> airports = airportService.getAllAirport();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), airports,
                            "All airports successfully fetched"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto>updateAirport(@PathVariable Integer id,
                                                       @Valid @RequestBody AirportRequest request){
        try {
            AirportDTO airport = airportService.updateAirport(id, request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), airport,
                            "airport updated successfully"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<ApiResponseDto>getAirportsCityId(@PathVariable Integer id){
        try {
            List<AirportDTO> airports = airportService.getAirportByCityId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), airports,
                            " airports with city id successfully fetched"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto>deleteAirport(@PathVariable Integer id){
        try {
            airportService.deleteAirport(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), null,
                            " airports successfully deleted"));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

}
