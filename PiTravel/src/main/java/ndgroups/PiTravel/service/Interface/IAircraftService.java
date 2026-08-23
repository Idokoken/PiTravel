package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.dto.AircraftDTO;
import ndgroups.PiTravel.request.AircraftRequest;

import java.time.LocalDate;
import java.util.List;

public interface IAircraftService {
    AircraftDTO addAircraft(AircraftRequest request) throws Exception;
    AircraftDTO getAircraftById(Integer aircraftId);
    AircraftDTO updateAircraft(Integer aircraftId, AircraftRequest request) throws Exception;
    void deleteAircraft(Integer aircraftId);
    List<AircraftDTO> getAllAircraft();
    List<AircraftDTO>getAircraftByAircraftName(String aircraftName);
    List<AircraftDTO> getAircraftByCurrentAirport(Integer id);
//    List<AircraftDTO> getAllAvailableAircraft();
//    List<AircraftDTO>getAircraftByDepartureDate(LocalDate departureDate);
//    List<AircraftDTO>getAircraftByDestination(String destination);
//    List<AircraftDTO> findAvailableAircraftByOriginAndDestinationAndDepartureDate(String origin,
//                                                                                  String destination,
//                                                                             LocalDate departureDate);


}
