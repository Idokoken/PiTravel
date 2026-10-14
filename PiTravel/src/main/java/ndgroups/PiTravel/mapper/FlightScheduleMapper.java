package ndgroups.PiTravel.mapper;

import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.dto.FlightScheduleDTO;
import ndgroups.PiTravel.model.Flight;
import ndgroups.PiTravel.model.FlightSchedule;
import ndgroups.PiTravel.request.FlightScheduleRequest;

public class FlightScheduleMapper {
    public static FlightSchedule toFlightScheduleEntity(FlightScheduleRequest request, Flight flight){
        if(request == null || flight == null) return null;
        return FlightSchedule.builder()
                .flight(flight)
                .departureAirportId(flight.getDepartureAirportId())
                .arrivalAirportId(flight.getArrivalAirportId())
                .departureTime(request.getDepartureTime())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .operatingDays(request.getOperatingDays())
                .isActive(request.isActive())
                .build();
    }

    public static FlightScheduleDTO flightScheduleDTO(FlightSchedule flightSchedule,
                                                      AirportDTO arrival,
                                                      AirportDTO departure){
        if(flightSchedule == null) return  null;
        return FlightScheduleDTO.builder()
                .id(flightSchedule.getId())
                .flightId(flightSchedule.getFlight() != null ? flightSchedule.getFlight().getId() : null)
                .flightNumber(flightSchedule.getFlight() != null ? flightSchedule.getFlight()
                        .getFlightNumber() : null)
                .departureAirport(departure)
                .arrivalAirport(arrival)
                .departureTime(flightSchedule.getDepartureTime())
                .arrivalTime(flightSchedule.getArrivalTime())
                .startDate(flightSchedule.getStartDate())
                .endDate(flightSchedule.getEndDate())
                .operatingDays(flightSchedule.getOperatingDays())
                .isActive(flightSchedule.isActive())
                .build();
    }      

    public static void updateFlightScheduleEntity(FlightSchedule flightSchedule,
                                                            FlightScheduleRequest request){
        if(request == null || flightSchedule == null) return;

        if(request.getDepartureTime() != null){
            flightSchedule.setDepartureTime(request.getDepartureTime());
        }
        if (request.getArrivalTime() != null){
            flightSchedule.setArrivalTime(request.getArrivalTime());
        }
        if(request.getEndDate() != null){
            flightSchedule.setStartDate(request.getStartDate());
        }
        if(request.getEndDate() != null){
            flightSchedule.setEndDate(request.getEndDate());
        }
        if(request.getOperatingDays() != null){
            flightSchedule.setOperatingDays(request.getOperatingDays());
        }
        if(request.isActive()){
            flightSchedule.setActive(request.isActive());
        }

    }




}
