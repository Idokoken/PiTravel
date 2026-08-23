package ndgroups.PiTravel.dto;

import lombok.*;
import ndgroups.PiTravel.Enum.FLIGHT_STATUS;

import java.time.Instant;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FlightDTO {
    private Integer id;
    private String flightNumber;
    private AircraftDTO aircraft;
    private AirportDTO departureAirport;
    private AirportDTO arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private FLIGHT_STATUS flightStatus;
    private Double lowestPrice;
    private Integer lowestAvailableSeats;
    private Instant createdAt;
    private Instant updatedAt;

}
