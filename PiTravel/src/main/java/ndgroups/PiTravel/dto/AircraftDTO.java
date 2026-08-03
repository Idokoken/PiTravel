package ndgroups.PiTravel.dto;

import lombok.*;
import ndgroups.PiTravel.Enum.AIRCRAFT_STATUS;

import java.time.Instant;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AircraftDTO {
    private Integer id;
    private String aircraftName;
    private String code;
    private String model;
    private String manufacturer;
    private Integer seatingCapacity;
    private Integer economySeats = 0;
    private Integer premiumEconomySeats = 0;
    private Integer businessSeat = 0;
    private Integer firstClassSeat = 0;
    private Integer rangeKm;
    private Integer cruisingSpeedKmh;
    private Integer maxAltitudeFeet;
    private Integer yearOfManufacture;
    private LocalDate registrationDate;
    private LocalDate nextMaintenanceDate;
    private AIRCRAFT_STATUS aircraftStatus;
    private boolean isAvailable;

    private Integer currentAirportId;
    private Integer currentAirportCapacity;
    private String currentAirportCode;
    private String currentAirportName;

    private Integer totalSeats;
    private Boolean requiredMaintenance;
    private Boolean isOperational;

    private Instant createdAt;
    private Instant updatedAt;

}
