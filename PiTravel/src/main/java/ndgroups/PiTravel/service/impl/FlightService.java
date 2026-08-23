package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import ndgroups.PiTravel.dto.FlightDTO;
import ndgroups.PiTravel.repository.FlightRepository;
import ndgroups.PiTravel.request.FlightRequest;
import ndgroups.PiTravel.service.Interface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlightService implements IFlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightDTO createFlight(FlightRequest request) {
        return null;
    }

    @Override
    public FlightDTO getFlightById(Integer id) {
        return null;
    }

    @Override
    public FlightDTO updateFlight(Integer id, FlightRequest request) {
        return null;
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return List.of();
    }

    @Override
    public Page<FlightDTO> getFlightByDepartureAndArrivalAirport(Integer departureAirportId, Integer arrivalAirportId, Pageable pageable) {
        return null;
    }

    @Override
    public List<FlightDTO> getAllAvailableFight() {
        return List.of();
    }

    @Override
    public FlightDTO changeFightStatus(Integer id, FLIGHT_STATUS status) {
        return null;
    }

    @Override
    public void deleteFlight(Integer id) {

    }
}
