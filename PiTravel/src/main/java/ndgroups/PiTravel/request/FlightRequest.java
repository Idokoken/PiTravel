package ndgroups.PiTravel.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import ndgroups.PiTravel.Enum.FLIGHT_STATUS;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlightRequest {
    @NotBlank(message = "Flight number is required")
    @Size(max = 10)
    private String flightNumber;
    @NotNull(message = "Aircraft ID is required")
    private Integer aircraftId;
    @NotNull(message = "Departure Airport ID is required")
    private Integer departureAirportId;
    @NotNull(message = "Arrival Airport ID is required")
    private Integer arrivalAirportId;
    private FLIGHT_STATUS flightStatus;
}
