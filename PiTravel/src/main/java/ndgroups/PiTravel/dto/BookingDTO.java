package ndgroups.PiTravel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {
    private Integer bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer numOfAdult;
    private Integer numOfChildren;
    private Integer totalNumOfGuest;
    private String bookingConfirmationCode;
    private UserDTO user;
    private PlaneDTO plane;
    private LocalDateTime CreatedAt;
    private LocalDateTime updatedAt;
}
