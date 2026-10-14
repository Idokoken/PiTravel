package ndgroups.PiTravel.mapper;

import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.dto.FlightInstanceDTO;
import ndgroups.PiTravel.model.Flight;
import ndgroups.PiTravel.model.FlightInstance;
import ndgroups.PiTravel.request.FlightInstanceRequest;

public class FlightInstanceMapper {
    public static FlightInstance toFlightInstanceEntity(FlightInstanceRequest request, Flight flight){
        if(flight == null)return null;

        return FlightInstance.builder()
                .flight(flight)
                .scheduleId(request.getScheduleId())
                .departureAirportId(request.getDepartureAirportId() != null ?
                        request.getDepartureAirportId() :
                        null)
                .arrivalAirportId(request.getArrivalAirportId() != null ?
                        request.getArrivalAirportId() :
                        null)
                .departureDateTime(request.getDepartureDateTime())
                .arrivalDateTime(request.getArrivalDateTime())
                .status(FLIGHT_STATUS.SCHEDULED)
                .minAdvanceBookingDays(request.getMinAdvanceBookingDays())
                .maxAdvanceBookingDays(request.getMaxAdvanceBookingDays())
                .isActive(request.getIsActive()!= null ? request.getIsActive() : false)
                .build();
    }

    public static FlightInstanceDTO toFlightInstanceDTO(FlightInstance fl, AircraftDTO aircraftDTO,
                                                        AirportDTO departureAirport,
                                                        AirportDTO arrivalAirport) {
        if (fl == null) return null;
        return FlightInstanceDTO.builder()
                .id(fl.getId())
                .flightId(fl.getFlight() != null ? fl.getFlight().getId() : null)
                .flightNumber(fl.getFlight() != null ? fl.getFlightNumber() : null)
                .aircraftId(fl.getFlight().getAircraftId())
                .aircraftModel(aircraftDTO.getModel())
                .aircraftCode(aircraftDTO.getCode())
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .departureDateTime(fl.getDepartureDateTime())
                .arrivalDateTime(fl.getArrivalDateTime())
                .formattedDuration(fl.getFormatedDuration())
                .totalSeats(fl.getTotalSeats())
                .availableSeats(fl.getAvailableSeats())
                .status(fl.getStatus())
                .minAdvanceBookingDays(fl.getMinAdvanceBookingDays())
                .maxAdvanceBookingDays(fl.getMaxAdvanceBookingDays())
                .isActive(fl.isActive())
//                .terminal(fl.getTerminal())
//                .gate(fl.getDate())
//                .version(fl.getVersion())
                .build();
    }


    public static FlightInstance updateEntity(FlightInstanceRequest request, FlightInstance existing){
        if (request == null || existing == null) return null;
        if (request.getDepartureAirportId() != null) existing.setDepartureAirportId(
                request.getDepartureAirportId());
        if (request.getArrivalAirportId() != null) existing.setArrivalAirportId(
                request.getArrivalAirportId());
        if (request.getDepartureDateTime() != null) existing.setDepartureDateTime(
                request.getDepartureDateTime());
        if (request.getArrivalDateTime() != null) existing.setArrivalDateTime(
                request.getArrivalDateTime());
        if (request.getAvailableSeats() != null) existing.setAvailableSeats(request.getAvailableSeats());
        if (request.getStatus() != null) existing.setStatus(request.getStatus());
        if (request.getMinAdvanceBookingDays() != null) existing.setMinAdvanceBookingDays(
                request.getMinAdvanceBookingDays());
        if (request.getMaxAdvanceBookingDays() != null) existing.setMaxAdvanceBookingDays(
                request.getMaxAdvanceBookingDays());
        if (request.getIsActive() != null) existing.setActive(request.getIsActive());

        return existing;

    }


}
