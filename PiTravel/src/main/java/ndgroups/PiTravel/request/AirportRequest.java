package ndgroups.PiTravel.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import ndgroups.PiTravel.embeddable.Address;
import ndgroups.PiTravel.embeddable.GeoCode;

import java.time.ZoneId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AirportRequest {
    @NotBlank(message = "Airport name is required")
    private String name;
    private String detailedName;
    @NotBlank(message = "IATA Code is mandatory")
    @Size(min = 3, max = 3, message = "length must be 3 characters")
    private String iataCode;
    private ZoneId timezone;
    @Valid
    private Address address;
    @Valid
    private GeoCode geoCode;
    @NotBlank(message = "City ID is required")
    private Integer cityId;
}
