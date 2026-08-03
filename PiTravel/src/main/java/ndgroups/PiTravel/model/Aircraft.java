package ndgroups.PiTravel.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import ndgroups.PiTravel.Enum.AIRCRAFT_STATUS;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String aircraftName;
    @Column(unique = true, nullable = false)
    private String code;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false, length = 50)
    private String manufacturer;
    @Column(nullable = false)
    private Integer seatingCapacity;
    @Column(name = "economy_seats")
    private Integer economySeats = 0;
    @Column(name = "premium_economy_seats")
    private Integer premiumEconomySeats = 0;
    @Column(name = "business_seats")
    private Integer businessSeat = 0;
    @Column(name = "first_class_seats")
    private Integer firstClassSeat = 0;
    private Integer rangeKm;
    private Integer cruisingSpeedKmh;
    private Integer maxAltitudeFeet;
    @Column(name = "year_of_manufacture")
    private Integer yearOfManufacture;
    private LocalTime registrationDate;
    private LocalDate nextMaintenanceDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AIRCRAFT_STATUS aircraftStatus =AIRCRAFT_STATUS.ACTIVE;
    private boolean isAvailable = true;
    private Integer currentAirportId;
    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public Integer getTotalSeats(){
        return economySeats + premiumEconomySeats + businessSeat + firstClassSeat;
    }

    public boolean isOperational() {
        return AIRCRAFT_STATUS.ACTIVE.equals(aircraftStatus) && Boolean.TRUE.equals(isAvailable);
    }
    public boolean requiredMaintenance(){
        return nextMaintenanceDate != null &&
                nextMaintenanceDate.isBefore(LocalDate.now().plusWeeks(2));
    }

//    private String origin;
//    private String destination;
//    private LocalDate departureDate;
//    private LocalTime departureTime;
//    private Double price;
//    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Booking> bookings = new ArrayList<>();
//    @OneToMany(mappedBy = "plane", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<CartItem> cartItem = new ArrayList<>();




}
