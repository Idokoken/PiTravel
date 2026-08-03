package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.dto.CityDTO;
import ndgroups.PiTravel.mapper.CityMapper;
import ndgroups.PiTravel.model.City;
import ndgroups.PiTravel.repository.CityRepository;
import ndgroups.PiTravel.request.CityRequest;
import ndgroups.PiTravel.service.Interface.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public CityDTO createCity(CityRequest request) throws Exception {
        if(cityRepository.existsByCityCode(request.getCityCode())){
            throw new Exception("city with code already exist");
        }
        City city = CityMapper.toCityEntity(request);
        City savedCity = cityRepository.save(city);

        return CityMapper.toCityDto(savedCity);
    }

    @Override
    public CityDTO getCityById(Integer id) throws Exception {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new Exception("city not found with the given Id"));
        return CityMapper.toCityDto(city);
    }

    @Override
    public CityDTO updateCity(Integer id, CityRequest request) throws Exception {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new Exception("city not found with the given Id"));
        if (cityRepository.existsByCityCode(request.getCityCode())){
            throw new Exception("city already exist with the given CityCode");
        }
        City updatedCity = CityMapper.updateCityEntity(city, request);
        City savedCity = cityRepository.save(updatedCity);

        return CityMapper.toCityDto(savedCity);
    }

    @Override
    public void deleteCity(Integer id) throws Exception {
       if(!cityRepository.existsById(id)){
           throw new Exception("city not found with the given Id");
       }
       cityRepository.deleteById(id);
    }

    @Override
    public Page<CityDTO> getAllCities(Pageable pageable) {
        return cityRepository.findAll(pageable).map(CityMapper::toCityDto);
    }

    @Override
    public Page<CityDTO> searchCity(String keyword, Pageable pageable) {
        return cityRepository.searchByKeyword(keyword, pageable).map(CityMapper::toCityDto);
    }

    @Override
    public Page<CityDTO> getCityByCountryCode(String countryCode, Pageable pageable) {
        return cityRepository.findByCountryCode(countryCode, pageable).map(CityMapper::toCityDto);
    }

    @Override
    public boolean cityExists(String cityCode) {
        return cityRepository.existsByCityCode(cityCode);
    }

}
