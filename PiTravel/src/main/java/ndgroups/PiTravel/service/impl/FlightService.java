package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.dto.FlightDTO;
import ndgroups.PiTravel.mapper.FlightMapper;
import ndgroups.PiTravel.model.Flight;
import ndgroups.PiTravel.repository.AircraftRepository;
import ndgroups.PiTravel.repository.FlightRepository;
import ndgroups.PiTravel.request.FlightRequest;
import ndgroups.PiTravel.service.Interface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlightService implements IFlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public FlightDTO createFlight(FlightRequest request) throws Exception {
        if(flightRepository.existsByFlightNumber(request.getFlightNumber())){
            throw new Exception("flight already exist");
        }
        Flight flight = FlightMapper.toFlightEntity(request);
        Flight savedFlight = flightRepository.save(flight);

        return convertToFlightDTO(savedFlight);
    }

    @Override
    public FlightDTO getFlightById(Integer id) throws Exception {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new Exception("flight with Id not found"));
        return convertToFlightDTO(flight);
    }

    @Override
    public FlightDTO updateFlight(Integer id, FlightRequest request) throws Exception {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new Exception("flight with Id not found"));

        if(request.getFlightNumber() != null &&
        flightRepository.existsByFlightNumberAndIdNot(request.getFlightNumber(), id)) {
            throw new Exception("Flight with Id already exist");
        }

        FlightMapper.updateEntity(request, flight);
        Flight updated = FlightMapper.toFlightEntity(request);

        return convertToFlightDTO(updated);

    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return flightRepository.findAll().stream().map(this::convertToFlightDTO)
                .collect(Collectors.toList());

    }

    @Override
    public Page<FlightDTO> getFlightByDepartureAndArrivalAirport(Integer departureAirportId,
                                                                 Integer arrivalAirportId,
                                                                 Pageable pageable) {
        return flightRepository.findByByDepartureAirportIdAndArrivalAirportId(departureAirportId,
                arrivalAirportId, pageable).map(this::convertToFlightDTO);
    }

    @Override
    public List<FlightDTO> getAllAvailableFight() {
       return flightRepository.findByFlightStatus(FLIGHT_STATUS.SCHEDULED).stream()
               .map(this::convertToFlightDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO changeFightStatus(Integer id, FLIGHT_STATUS status) throws Exception {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new Exception("flight with Id not found"));
        flight.setFlightStatus(status);
        flightRepository.save(flight);
        return convertToFlightDTO(flight);
    }

    @Override
    public void deleteFlight(Integer id) throws Exception {
         if(!flightRepository.existsById(id)){
             throw new Exception("flight with Id not found");
         }
         flightRepository.deleteById(id);
    }

    public FlightDTO convertToFlightDTO(Flight flight){
        AircraftDTO aircraft = AircraftDTO.builder()
                .id(flight.getAircraftId()).build();
        AirportDTO departureAirport = AirportDTO.builder()
                .id(flight.getDepartureAirportId()).build();
        AirportDTO arrivalAirport = AirportDTO.builder()
                .id(flight.getArrivalAirportId()).build();

        return FlightMapper.toFlightDto(flight, aircraft, departureAirport ,arrivalAirport);
    }

}
