package ndgroups.PiTravel.model;

import jakarta.persistence.*;
import lombok.*;
import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Duration;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class FlightInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Flight flight;
    private String flightNumber;
    @Column(nullable = false)
    private Integer departureAirportId;
    private Integer arrivalAirportId;
    @Column(nullable = false)
    private Integer scheduleId;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    @Column(nullable = false)
    private Integer totalSeats;
    @Column(nullable = false)
    private Integer AvailableSeats;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FLIGHT_STATUS status;

    private Integer minAdvanceBookingDays;
    private Integer maxAdvanceBookingDays;

    private boolean isActive = true;
    @Transient
   public String getFormatedDuration() {
       if(departureDateTime == null || arrivalDateTime == null){
           return  null;
       }
       Duration duration = Duration.between(departureDateTime, arrivalDateTime);
       long hours = duration.toHours();
       long minutes = duration.toMinutesPart();

       StringBuilder sb = new StringBuilder();
       if(hours > 0)sb.append(hours).append("h ");
       if(minutes > 0)sb.append(minutes).append("min ");

       return sb.toString().trim();
   }


}
