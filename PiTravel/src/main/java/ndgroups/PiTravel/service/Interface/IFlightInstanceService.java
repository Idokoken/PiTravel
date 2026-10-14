package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.dto.FlightInstanceDTO;
import ndgroups.PiTravel.request.FlightInstanceRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IFlightInstanceService {
    FlightInstanceDTO createFlightInstance(FlightInstanceRequest request) throws Exception;
    FlightInstanceDTO getFlightInstanceById(Integer id) throws Exception;
    FlightInstanceDTO updateFlightInstance(Integer id, FlightInstanceRequest request) throws Exception;
    void deleteFlightInstance(Integer id) throws Exception;
//    Page<FlightInstanceDTO> getFlightInstances(Pageable pageable,
//                                            Integer departureAirportId,
//                                            Integer arrivalAirportId,
//                                            Integer flightId,
//                                            LocalDate onDate);

}
