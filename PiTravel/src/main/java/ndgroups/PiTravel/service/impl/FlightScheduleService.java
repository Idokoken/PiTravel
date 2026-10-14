package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.dto.FlightScheduleDTO;
import ndgroups.PiTravel.mapper.FlightScheduleMapper;
import ndgroups.PiTravel.model.Flight;
import ndgroups.PiTravel.model.FlightSchedule;
import ndgroups.PiTravel.repository.FlightRepository;
import ndgroups.PiTravel.repository.FlightScheduleRepository;
import ndgroups.PiTravel.request.FlightInstanceRequest;
import ndgroups.PiTravel.request.FlightScheduleRequest;
import ndgroups.PiTravel.service.Interface.IFlightInstanceService;
import ndgroups.PiTravel.service.Interface.IFlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightScheduleService implements IFlightScheduleService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightScheduleRepository flightScheduleRepository;
    @Autowired
    private IFlightInstanceService flightInstanceService;

    @Override
    public FlightScheduleDTO createFlightSchedule(FlightScheduleRequest request) throws Exception {
        Flight flight = flightRepository.findById(request.getFlightId())
                .orElseThrow(() -> new Exception("flight with Id not found"));
        if(request.getEndDate().isBefore(request.getStartDate())){
            throw  new Exception("End Date is before Start Date");
        }
        FlightSchedule flightSchedule = FlightScheduleMapper.toFlightScheduleEntity(request, flight);
        FlightSchedule savedSchedule = flightScheduleRepository.save(flightSchedule);

//        create flight instance for saved schedule
//        mon, tue, wed, thur
        List<DayOfWeek> operatingDays = savedSchedule.getOperatingDays();
        LocalDate startDate = savedSchedule.getStartDate();
        LocalDate endDate = savedSchedule.getEndDate();

        FlightInstanceRequest flightInstanceRequest = FlightInstanceRequest
                .builder()
                .scheduleId(savedSchedule.getId())
                .flightId(flight.getId())
                .arrivalAirportId(flight.getArrivalAirportId())
                .departureAirportId(flight.getDepartureAirportId())
                .status(FLIGHT_STATUS.SCHEDULED)
                .build();

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.minusDays(1)){
            if (operatingDays.contains(date.getDayOfWeek())){
                flightInstanceRequest.setDepartureDateTime(
                        LocalDateTime.of(date, savedSchedule.getDepartureTime())
                );
                flightInstanceRequest.setArrivalDateTime(
                        LocalDateTime.of(date, savedSchedule.getArrivalTime())
                );

                flightInstanceService.createFlightInstance(flightInstanceRequest);
            }
        }

       return convertToFlightScheduleDTO(flightSchedule);
     }

    @Override
    public FlightScheduleDTO getFLightScheduleById(Integer id) throws Exception {

        FlightSchedule flightSchedule = flightScheduleRepository.findById(id)
                .orElseThrow(() -> new Exception("flight schedule Id not found"));
        return convertToFlightScheduleDTO(flightSchedule);
    }

    @Override
    public List<FlightScheduleDTO> getAllFlightSchedule() {
        return flightScheduleRepository.findAll().stream().map(this::convertToFlightScheduleDTO)
                .toList();
    }

    @Override
    public FlightScheduleDTO updateFlightSchedule(FlightScheduleRequest request, Integer id) throws Exception {
        FlightSchedule flightSchedule = flightScheduleRepository.findById(id)
                .orElseThrow(() -> new Exception("flight schedule Id not found"));
        FlightScheduleMapper.updateFlightScheduleEntity(
                flightSchedule, request);
        FlightSchedule updatedSchedule = flightScheduleRepository.save(flightSchedule);
        return convertToFlightScheduleDTO(updatedSchedule);
    }

    @Override
    public void deleteFlightSchedule(Integer id) throws Exception {
        if(!flightScheduleRepository.existsById(id)){
            throw new Exception("Flight schedule Id not found");
        }
       flightScheduleRepository.deleteById(id);
    }

    public FlightScheduleDTO convertToFlightScheduleDTO(FlightSchedule flightSchedule){
//        todo : service to service communication
        AirportDTO departureAirport = AirportDTO.builder()
                .id(flightSchedule.getDepartureAirportId())
                .build();
        AirportDTO arrivalAirport = AirportDTO.builder()
                .id(flightSchedule.getArrivalAirportId())
                .build();

        return  FlightScheduleMapper.flightScheduleDTO(flightSchedule, arrivalAirport, departureAirport);
    }


}
