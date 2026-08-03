package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.request.AirportRequest;

import java.util.List;

public interface IAirportService {
    AirportDTO createAirport(AirportRequest request) throws Exception;
    AirportDTO getAirportById(Integer id) throws Exception;
    List<AirportDTO>getAllAirport();
    AirportDTO updateAirport(Integer id, AirportRequest request) throws Exception;
    List<AirportDTO>getAirportByCityId(Integer cityId);
    void deleteAirport(Integer id) throws Exception;
}
