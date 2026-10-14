package ndgroups.PiTravel.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import ndgroups.PiTravel.model.Flight;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FlightInstanceDTO {
    private Integer id;
    private Integer flightId;
    private String flightNumber;
    private Integer aircraftId;
    private String aircraftModel;
    private String aircraftCode;
    private AirportDTO departureAirport;
    private AirportDTO arrivalAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String formattedDuration;
    private Integer totalSeats;
    private Integer availableSeats;
    private FLIGHT_STATUS status;
    private Integer minAdvanceBookingDays;
    private Integer maxAdvanceBookingDays;
    private Boolean isActive;


}
