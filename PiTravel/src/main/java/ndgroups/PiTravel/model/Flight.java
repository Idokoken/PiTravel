package ndgroups.PiTravel.model;

import jakarta.persistence.*;
import lombok.*;
import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String flightNumber;
    @Column(nullable = false)
    private Integer aircraftId;
    @Column(nullable = false)
    private Integer departureAirportId;
    @Column(nullable = false)
    private Integer arrivalAirportId;
//    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FLIGHT_STATUS flightStatus = FLIGHT_STATUS.SCHEDULED;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;
}
