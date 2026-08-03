package ndgroups.PiTravel.controller;

import jakarta.validation.Valid;
import ndgroups.PiTravel.dto.CityDTO;
import ndgroups.PiTravel.request.CityRequest;
import ndgroups.PiTravel.response.ApiResponseDto;
import ndgroups.PiTravel.service.Interface.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/${api.prefix}/cities")
public class CityController {
    @Autowired
    private ICityService cityService;

    @PostMapping
    public ResponseEntity<ApiResponseDto>createCity(@Valid @RequestBody CityRequest request){
        try {
            CityDTO city = cityService.createCity(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), city,
                            "city created"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto>getCityById(@PathVariable Integer id){
        try {
            CityDTO city = cityService.getCityById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), city,
                            "city successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponseDto>getAllCities(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "20") int size,
                                                      @RequestParam(defaultValue = "name") String sortBy,
                                                      @RequestParam(defaultValue = "asc") String sortDirection){
        try {
            Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
            Pageable pageable = PageRequest.of(page, size, sort);
            Page<CityDTO> cities = cityService.getAllCities(pageable);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), cities,
                            "cities successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto>updateCity(@PathVariable Integer id,
                                                      @Valid @RequestBody CityRequest request){
        try {
            CityDTO city = cityService.updateCity(id, request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), city,
                            "city updated successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto>deleteCity(@PathVariable Integer id){
        try {
            cityService.deleteCity(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), null,
                            "city deleted"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponseDto>searchCity(@RequestParam String keyword,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "20") int size){
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<CityDTO> cities = cityService.searchCity(keyword, pageable);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), cities,
                            "cities successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/country/{countryCode}")
    public ResponseEntity<ApiResponseDto>getCitiesByCountryCode(@PathVariable String countryCode,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "20") int size){
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<CityDTO> cities = cityService.getCityByCountryCode(countryCode.toUpperCase(  ), pageable);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), cities,
                            "Cities successfully fetched"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/exists/{cityCode}")
    public ResponseEntity<ApiResponseDto>checkIfCityExist(@PathVariable String countryCode){
        try {
            boolean isExist = cityService.cityExists(countryCode);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), isExist,
                            "City Exist"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponseDto<>(false, HttpStatus.NOT_FOUND.value(),
                            null, e.getMessage()));
        }
    }


}
