package ndgroups.PiTravel.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import ndgroups.PiTravel.Enum.FLIGHT_STATUS;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FlightInstanceRequest {
    private Integer id;
    @NotNull(message = "flight Id is required")
    private Integer flightId;
    private Integer scheduleId;
    private Integer aircraftId;
    private Integer departureAirportId;
    private Integer arrivalAirportId;
    @NotNull(message = "Departure Date-time is required")
    private LocalDateTime departureDateTime;
    @NotNull(message = "Arrival Date-time is required")
    private LocalDateTime arrivalDateTime;
    @NotNull(message = "Total seats is required")
    @Positive
    private Integer totalSeats;
    @PositiveOrZero
    private Integer AvailableSeats;
    private FLIGHT_STATUS status;
    private Integer minAdvanceBookingDays;
    private Integer maxAdvanceBookingDays;
    private Boolean isActive;


}
