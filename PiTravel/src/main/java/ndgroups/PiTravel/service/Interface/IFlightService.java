package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import ndgroups.PiTravel.dto.FlightDTO;
import ndgroups.PiTravel.request.FlightRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFlightService {
    FlightDTO createFlight(FlightRequest request);
    FlightDTO getFlightById(Integer id);
    FlightDTO updateFlight(Integer id, FlightRequest request);
    List<FlightDTO> getAllFlights();
    Page<FlightDTO> getFlightByDepartureAndArrivalAirport(Integer departureAirportId,
                                                          Integer arrivalAirportId, Pageable pageable);
    List<FlightDTO> getAllAvailableFight();
    FlightDTO changeFightStatus(Integer id, FLIGHT_STATUS status);
    void deleteFlight(Integer id);
}
