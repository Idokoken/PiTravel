package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.dto.FlightScheduleDTO;
import ndgroups.PiTravel.request.FlightScheduleRequest;

import java.util.List;

public interface IFlightScheduleService {
    FlightScheduleDTO createFlightSchedule(FlightScheduleRequest request) throws Exception;
    FlightScheduleDTO getFLightScheduleById(Integer id) throws Exception;
    List<FlightScheduleDTO> getAllFlightSchedule();
    FlightScheduleDTO updateFlightSchedule(FlightScheduleRequest request, Integer id) throws Exception;
    void deleteFlightSchedule(Integer id) throws Exception;

}
