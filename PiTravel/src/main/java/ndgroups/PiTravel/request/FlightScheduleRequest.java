package ndgroups.PiTravel.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import ndgroups.PiTravel.dto.AirportDTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FlightScheduleRequest {
    private Integer flightId;
    @NotNull(message = "flight ID is required")
    private String flightNumber;
    @NotNull(message = "Departure time is required")
    private LocalTime departureTime;
    @NotNull(message = "Arrival time is required")
    private LocalTime arrivalTime;
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    @NotNull(message = "End date is required")
    private LocalDate endDate;

    private List<DayOfWeek> operatingDays;
    private boolean isActive;
}
