package ndgroups.PiTravel.dto;

import lombok.Data;
import ndgroups.PiTravel.model.Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PlaneDTO {
    private Integer id;
    private String planeName;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private Integer availableSeats;
    private Double price;
    private List<Booking> bookings = new ArrayList<>();
}
