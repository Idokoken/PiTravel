package ndgroups.PiTravel.mapper;

import ndgroups.PiTravel.dto.CityDTO;
import ndgroups.PiTravel.model.City;
import ndgroups.PiTravel.request.CityRequest;

public class CityMapper {
    public static City toCityEntity(CityRequest request){
        if(request == null) return  null;
        return City.builder()
                .name(request.getName())
                .cityCode(request.getCityCode())
                .countryCode(request.getCountryCode())
                .countryName(request.getCountryName())
                .regionCode(request.getRegionCode())
                .timeZoneId(request.getTimeZoneId())
                .build();
    }

    public static CityDTO toCityDto(City city){
        if(city == null) return  null;
        return CityDTO.builder()
                .id(city.getId())
                .name(city.getName())
                .cityCode(city.getCityCode())
                .countryCode(city.getCountryCode())
                .countryName(city.getCountryName())
                .regionCode(city.getRegionCode())
                .timeZoneId(city.getTimeZoneId())
                .build();
    }

    public static City updateCityEntity(City city, CityRequest request){
        if(request.getName() != null) {
            city.setName(request.getName().trim());
        }
        if(request.getCityCode() != null) {
            city.setCityCode(request.getCityCode().toUpperCase().trim());
        }
        if(request.getCountryCode() != null) {
            city.setCountryCode(request.getCountryCode().toUpperCase().trim());
        }
        if(request.getCountryName() != null) {
            city.setCountryName(request.getCountryName().trim());
        }
        if(request.getRegionCode() != null) {
            city.setRegionCode(request.getRegionCode().toUpperCase().trim());
        }

        return city;
    }


}
