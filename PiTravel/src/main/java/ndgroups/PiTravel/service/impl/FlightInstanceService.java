package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.dto.FlightInstanceDTO;
import ndgroups.PiTravel.mapper.FlightInstanceMapper;
import ndgroups.PiTravel.model.Flight;
import ndgroups.PiTravel.model.FlightInstance;
import ndgroups.PiTravel.repository.FlightInstanceRepository;
import ndgroups.PiTravel.repository.FlightRepository;
import ndgroups.PiTravel.request.FlightInstanceRequest;
import ndgroups.PiTravel.service.Interface.IFlightInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class FlightInstanceService implements IFlightInstanceService {
    @Autowired
    private FlightInstanceRepository flightInstanceRepository;
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FlightInstanceDTO createFlightInstance(FlightInstanceRequest request) throws Exception {
        Flight flight = flightRepository.findById(request.getFlightId())
                .orElseThrow(() -> new Exception("Flight not found"));

//        Dummy Aircraft
        AircraftDTO aircraft = AircraftDTO.builder()
                .id(1)
                .totalSeats(90)
                .build();

        FlightInstance flightInstance = FlightInstanceMapper.toFlightInstanceEntity(request, flight);
        flightInstance.setTotalSeats(aircraft.getTotalSeats());
        flightInstance.setAvailableSeats(aircraft.getTotalSeats());

        FlightInstance savedInstance = flightInstanceRepository.save(flightInstance);
//        todo : create seat instances
        return convertToFlightInstanceDTO(savedInstance);

    }

    @Override
    public FlightInstanceDTO getFlightInstanceById(Integer id) throws Exception {
        FlightInstance flightInstance = flightInstanceRepository.findById(id)
                .orElseThrow(() -> new Exception("Flight Instance not found"));
        return convertToFlightInstanceDTO(flightInstance);
    }

    @Override
    public FlightInstanceDTO updateFlightInstance(Integer id, FlightInstanceRequest request) throws Exception {
        FlightInstance flightInstance = flightInstanceRepository.findById(id)
                .orElseThrow(() -> new Exception("Flight Instance not found"));
        FlightInstance updateInstance = FlightInstanceMapper.updateEntity(request, flightInstance);
        FlightInstance savedInstance = flightInstanceRepository.save(updateInstance);

        return convertToFlightInstanceDTO(savedInstance);
    }

    @Override
    public void deleteFlightInstance(Integer id) throws Exception {
        if (!flightInstanceRepository.existsById(id)){
            throw new Exception("Flight Instance not found");
        }
       flightInstanceRepository.deleteById(id);
    }

//    @Override
//    public Page<FlightInstanceDTO> getFlightInstances(Pageable pageable, Integer departureAirportId,
//                                                   Integer arrivalAirportId, Integer flightId,
//                                                   LocalDate onDate) {
//        LocalDateTime start = onDate != null? onDate.atStartOfDay() : null;
//        LocalDateTime end = onDate != null? onDate.plusDays(1).atStartOfDay() : null;
//
//        return flightInstanceRepository.findAllInstance(departureAirportId, arrivalAirportId,
//                        start, end, pageable)
//                .map(this::convertToFlightInstanceDTO);
//    }

    private FlightInstanceDTO convertToFlightInstanceDTO(FlightInstance flightInstance){
        AirportDTO departureAirport = AirportDTO.builder()
                .id(flightInstance.getDepartureAirportId())
                .build();
        AirportDTO arrivalAirport = AirportDTO.builder()
                .id(flightInstance.getArrivalAirportId())
                .build();
        AircraftDTO aircraftDTO = AircraftDTO.builder()
                .id(flightInstance.getFlight().getAircraftId())
                .build();

        return FlightInstanceMapper.toFlightInstanceDTO(flightInstance, aircraftDTO,
                departureAirport, arrivalAirport);
    }
}
