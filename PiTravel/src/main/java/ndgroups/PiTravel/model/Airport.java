package ndgroups.PiTravel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ndgroups.PiTravel.embeddable.Address;
import ndgroups.PiTravel.embeddable.GeoCode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true, length = 3)
    private String iataCode;
    @Column(name = "time_zone_id", length = 50)
    private String timeZone;
    @Embedded
    private Address address;
    @Embedded
    private GeoCode geoCode;
    @ManyToOne
    @JsonIgnore
    private City city;

    @JsonIgnore
    @Transient
    public String getDetailedName() {
        if(city != null && city.getCountryCode() != null){
            return name.toLowerCase() + "/" + city.getCityCode();
        }
        return name.toLowerCase();
    }

}
