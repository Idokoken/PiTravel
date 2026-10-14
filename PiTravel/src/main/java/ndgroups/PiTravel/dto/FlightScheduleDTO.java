package ndgroups.PiTravel.dto;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FlightScheduleDTO {
    private Integer id;
    private Integer flightId;
    private String flightNumber;

    private AirportDTO departureAirport;
    private AirportDTO arrivalAirport;

    private LocalTime departureTime;
    private LocalTime arrivalTime;

    private LocalDate startDate;
    private LocalDate endDate;

    private List<DayOfWeek> operatingDays;
    private boolean isActive;
}
