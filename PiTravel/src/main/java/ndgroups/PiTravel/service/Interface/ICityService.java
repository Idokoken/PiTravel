package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.dto.CityDTO;
import ndgroups.PiTravel.request.CityRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService {
    CityDTO createCity(CityRequest request) throws Exception;
    CityDTO getCityById(Integer id) throws Exception;
    CityDTO updateCity(Integer id, CityRequest request) throws Exception;
    void deleteCity(Integer id) throws Exception;
    Page<CityDTO>getAllCities(Pageable pageable);
    Page<CityDTO>searchCity(String keyword, Pageable pageable);
    Page<CityDTO> getCityByCountryCode(String countryCode, Pageable pageable);
    boolean cityExists(String cityCode);

}
