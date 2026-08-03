package ndgroups.PiTravel.mapper;

import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.model.Airport;
import ndgroups.PiTravel.request.AirportRequest;

public class AirportMapper {
    public static Airport toAirportEntity(AirportRequest request){
        if(request == null) return  null;
        return Airport.builder()
                .name(request.getName())
                .iataCode(request.getIataCode())
//                .timeZone(request.getTimezone())
                .address(request.getAddress())
                .geoCode(request.getGeoCode())
                .build();
    }

    public static AirportDTO toAirportDto(Airport airport){
        if(airport == null) return  null;
        return AirportDTO.builder()
                .id(airport.getId())
                .name(airport.getName())
                .iataCode(airport.getIataCode())
//                .timezone(airport.getTimeZone())
                .address(airport.getAddress())
                .geoCode(airport.getGeoCode())
                .city(CityMapper.toCityDto(airport.getCity()))
                .build();
    }

    public static Airport updateAirportEntity(Airport airport, AirportRequest request) {
        if (request.getName() != null) {
            airport.setName(request.getName().trim());
        }
        if (request.getIataCode() != null) {
            airport.setIataCode(request.getIataCode());
        }
//        if (request.getTimezone() != null) {
//            airport.setTimeZone(request.getTimezone());
//        }
        if (request.getAddress() != null) {
            airport.setAddress(request.getAddress());
        }
        if (request.getGeoCode() != null) {
            airport.setGeoCode(request.getGeoCode());
        }
        return airport;
    }


}
