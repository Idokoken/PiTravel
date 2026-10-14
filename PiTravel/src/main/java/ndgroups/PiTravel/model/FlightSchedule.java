package ndgroups.PiTravel.model;

import jakarta.persistence.*;
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
@Entity
public class FlightSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Flight flight;
    @Column(nullable = false)
    private Integer departureAirportId;
    @Column(nullable = false)
    private Integer arrivalAirportId;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> operatingDays;
    private boolean isActive = true;
}
