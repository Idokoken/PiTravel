package ndgroups.PiTravel.service.impl;

import jakarta.persistence.EntityNotFoundException;
import ndgroups.PiTravel.Exception.ResourceNotFoundException;
import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.mapper.AircraftMapper;
import ndgroups.PiTravel.model.Aircraft;
import ndgroups.PiTravel.repository.AircraftRepository;
import ndgroups.PiTravel.request.AircraftRequest;
import ndgroups.PiTravel.service.Interface.IAircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftService implements IAircraftService {
    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public AircraftDTO addAircraft(AircraftRequest request) throws Exception {
        if(aircraftRepository.existsByCode(request.getCode())){
            throw new Exception("aircraft with code already exist");
        }
        Aircraft aircraft = AircraftMapper.toAircraftEntity(request);
        if(aircraft.getSeatingCapacity() < aircraft.getTotalSeats()){
            throw new Exception("Seating Capacity can't exceed total seat");
        }

        Aircraft savedAircraft = aircraftRepository.save(aircraft);
        return AircraftMapper.toAircraftDto(savedAircraft);
    }
    @Override
    public AircraftDTO getAircraftById(Integer id) {
        Aircraft aircraft  = aircraftRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Aircraft not found with id: " + id));
        return  AircraftMapper.toAircraftDto(aircraft);
    }

    @Override
    public AircraftDTO updateAircraft(Integer aircraftId, AircraftRequest request) throws Exception {
        Aircraft aircraft = aircraftRepository.findById(aircraftId)
                .orElseThrow(() -> new Exception("aircraft with ID not found"));
        if(request.getCode() != null && !aircraft.getCode().equals(request.getCode())
                && aircraftRepository.existsByCode(request.getCode())){
            throw new Exception("aircraft with code already exist");
        }

        Aircraft aircraftUpdated = AircraftMapper.updateAircraftEntity(aircraft, request);
        Aircraft savedAircraft = aircraftRepository.save(aircraftUpdated);
        return AircraftMapper.toAircraftDto(savedAircraft);

    }

    @Override
    public void deleteAircraft(Integer id) {
        if (!aircraftRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aircraft not found with id: " + id);
        }
        aircraftRepository.deleteById(id);
    }
    @Override
    public List<AircraftDTO> getAllAircraft()  {
        return aircraftRepository.findAll().stream().map(AircraftMapper::toAircraftDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AircraftDTO> getAircraftByAircraftName(String aircraftName) {
        return aircraftRepository.findByAircraftName(aircraftName).stream().map(
                AircraftMapper::toAircraftDto).collect(Collectors.toList());
    }

    @Override
    public List<AircraftDTO> getAircraftByCurrentAirport(Integer id) {
        return aircraftRepository.findByCurrentAirportId(id).stream().map(AircraftMapper::toAircraftDto)
                .collect(Collectors.toList());
    }

    //    @Override
//    public List<AircraftDTO> getAllAvailableAircraft() {
//        return aircraftRepository.findAvailableAircraft(LocalDate.now()).stream().map(
//                AircraftMapper::toAircraftDto).collect(Collectors.toList());
//    }

//    @Override
//    public List<AircraftDTO> getAircraftByDepartureDate(LocalDate departureDate) {
//        return aircraftRepository.findByDepartureDate(departureDate).stream().map(
//                AircraftMapper::toAircraftDto
//        ).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AircraftDTO> getAircraftByDestination(String destination) {
//        return aircraftRepository.findByDestination(destination).stream().map(
//                AircraftMapper::toAircraftDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AircraftDTO> findAvailableAircraftByOriginAndDestinationAndDepartureDate
//            (String origin, String destination, LocalDate departureDate){
//        return aircraftRepository.findAvailableAircraftByOriginAndDestinationAndDepartureDate(origin,
//                destination, departureDate).stream().map(
//                        AircraftMapper::toAircraftDto).collect(Collectors.toList());
//    }


}
