package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.dto.AirportDTO;
import ndgroups.PiTravel.mapper.AirportMapper;
import ndgroups.PiTravel.model.Airport;
import ndgroups.PiTravel.model.City;
import ndgroups.PiTravel.repository.AirportRepository;
import ndgroups.PiTravel.repository.CityRepository;
import ndgroups.PiTravel.request.AirportRequest;
import ndgroups.PiTravel.service.Interface.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public AirportDTO createAirport(AirportRequest request) throws Exception {
        if(airportRepository.existsByIataCode(request.getIataCode())){
            throw new Exception("Airport with IataCode already exist");
        }
        City city = cityRepository.findById(request.getCityId())
                .orElseThrow(() -> new Exception("city not found"));

        Airport airport = AirportMapper.toAirportEntity(request);
        airport.setCity(city);
        Airport savedAirport = airportRepository.save(airport);

        return AirportMapper.toAirportDto(savedAirport);
    }

    @Override
    public AirportDTO getAirportById(Integer id) throws Exception {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new Exception("airport with Id not found"));

        return AirportMapper.toAirportDto(airport);
    }

    @Override
    public List<AirportDTO> getAllAirport() {
         return airportRepository.findAll().stream().map(AirportMapper::toAirportDto)
                .collect(Collectors.toList());

    }

    @Override
    public AirportDTO updateAirport(Integer id, AirportRequest request) throws Exception {
          Airport airport = airportRepository.findById(id)
                  .orElseThrow(() -> new Exception("airport with Id not found"));
          if (request.getIataCode() != null
                  && !airport.getIataCode().equals(request.getIataCode())
                  && airportRepository.existsByIataCode(request.getIataCode())){
              throw new Exception("airport with IATA code already exist");
          }
          Airport updatedAirport = AirportMapper.updateAirportEntity(airport, request);
          Airport savedAirport = airportRepository.save(updatedAirport);

          return AirportMapper.toAirportDto(savedAirport);
    }

    @Override
    public List<AirportDTO> getAirportByCityId(Integer cityId) {
        return airportRepository.findByCityId(cityId).stream().map(AirportMapper::toAirportDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAirport(Integer id) throws Exception {
        if(!airportRepository.existsById(id)){
            throw new Exception("airport with Id not found");
        }
        airportRepository.deleteById(id);
    }


}

