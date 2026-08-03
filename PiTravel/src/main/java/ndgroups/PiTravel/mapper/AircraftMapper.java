package ndgroups.PiTravel.mapper;

import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.model.Aircraft;
import ndgroups.PiTravel.request.AircraftRequest;

public class AircraftMapper {
    public static Aircraft toAircraftEntity(AircraftRequest request){
        if(request == null) return  null;
        return Aircraft.builder()
                .aircraftName(request.getAircraftName())

                .build();
    }

    public static AircraftDTO toAircraftDto(Aircraft aircraft){
        if(aircraft == null) return  null;
        return AircraftDTO.builder()
                .id(aircraft.getId())
                .aircraftName(aircraft.getAircraftName())

                .build();
    }

    public static Aircraft updateAircraftEntity(Aircraft aircraft, AircraftRequest request) {
        if (request.getAircraftName() != null) {
            aircraft.setAircraftName(request.getAircraftName().trim());
        }


        return aircraft;
    }
}
