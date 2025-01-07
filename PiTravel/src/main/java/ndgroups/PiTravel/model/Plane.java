package ndgroups.PiTravel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;
    private String trainCoach;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private Integer availableSeats;
    private Double price;
    @OneToMany(mappedBy = "Plane", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();
}
