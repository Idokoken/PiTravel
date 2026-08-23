package ndgroups.PiTravel.mapper;

import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.dto.FlightDTO;
import ndgroups.PiTravel.model.Flight;
import ndgroups.PiTravel.request.FlightRequest;

public class FlightMapper {
    public static Flight toFlightEntity(FlightRequest request){
        if(request == null) return  null;
        return Flight.builder()
                .flightNumber(request.getFlightNumber())
                .aircraftId(request.getAircraftId())
                .departureAirportId(request.getDepartureAirportId())
                .arrivalAirportId(request.getArrivalAirportId())
                .build();
    }

    public static FlightDTO toFlightDto(Flight flight, AircraftDTO aircraft, AirportDTO departureAirport,
                                        AirportDTO arrivalAirport){
        if (flight == null) return null;
        return FlightDTO.builder()
                .id(flight.getId())
                .flightNumber(flight.getFlightNumber())
                .aircraft(aircraft)
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .flightStatus(flight.getFlightStatus())
                .createdAt(flight.getCreatedAt())
                .updatedAt(flight.getUpdatedAt())
                .build();
    }

    public static void updateEntity(FlightRequest request, Flight flight){
        if(request == null || flight == null) return;
        if(request.getFlightNumber() != null) flight.setFlightNumber(request.getFlightNumber());
        if(request.getAircraftId() != null) flight.setAircraftId(request.getAircraftId());
        if(request.getDepartureAirportId() != null) flight.setDepartureAirportId(request.getDepartureAirportId());
        if(request.getArrivalAirportId() != null) flight.setArrivalAirportId(request.getArrivalAirportId());
    }


}
