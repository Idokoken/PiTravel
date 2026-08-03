package ndgroups.PiTravel.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ndgroups.PiTravel.Enum.AIRCRAFT_STATUS;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AircraftRequest {
    private String aircraftName;
    @NotBlank(message = "Aircraft code is required")
    private String code;
    @NotBlank(message = "Aircraft model is required")
    private String model;
    @NotBlank(message = "manufacturer is required")
    private String manufacturer;
    @NotNull(message = "seat capacity is required")
    @Positive(message = "seating capacity must be positive")
    private Integer seatingCapacity;
    @Positive(message = "economy seats must be positive")
    private Integer economySeats = 0;
    @Positive(message = "premium economy seats must be positive")
    private Integer premiumEconomySeats = 0;
    @Positive(message = "business seats must be positive")
    private Integer businessSeat = 0;
    @Positive(message = "business seats must be positive")
    private Integer firstClassSeat = 0;
    @Positive(message = "range must be positive")
    private Integer rangeKm;
    @Positive(message = "cruising speed must be positive")
    private Integer cruisingSpeedKmh;
    @Positive(message = "max altitude must be positive")
    private Integer maxAltitudeFeet;
    @NotBlank(message =  "field is required")
    @Positive(message = "year of manufacture must be positive")
    private Integer yearOfManufacture;
    private LocalDate registrationDate;
    private LocalDate nextMaintenanceDate;
    @NotBlank(message =  "field is required")
    private AIRCRAFT_STATUS aircraftStatus =AIRCRAFT_STATUS.ACTIVE;
    private boolean isAvailable = true;
    private Integer currentAirportId;
}
