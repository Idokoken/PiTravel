package ndgroups.PiTravel.embeddable;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GeoCode {
    private Double latitude;
    private Double longitude;
}
