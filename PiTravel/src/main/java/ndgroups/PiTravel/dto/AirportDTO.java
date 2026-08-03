package ndgroups.PiTravel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ndgroups.PiTravel.embeddable.Address;
import ndgroups.PiTravel.embeddable.GeoCode;

import java.time.ZoneId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AirportDTO {
    private Integer id;
    private String name;
    private String detailedName;
    private String iataCode;
    private ZoneId timezone;
    private Address address;
    private GeoCode geoCode;
    private CityDTO city;
}
