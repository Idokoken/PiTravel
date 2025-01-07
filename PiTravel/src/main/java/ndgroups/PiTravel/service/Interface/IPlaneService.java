package ndgroups.PiTravel.service.Interface;

import ndgroups.PiTravel.model.Plane;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface IPlaneService {
    Plane addPlane(Plane plane);
    Plane getPlaneById(Integer planeId);
    Plane updatePlane(Integer planeId, Plane plane);
    void deletePlane(Integer PlaneId);
    List<Plane> getAllPlanes();
    List<Plane> getAllAvailablePlanes();
    List<Plane> findAvailablePlanesByOriginAndDestinationAndDepartureDate(String origin, String destination,
                                                                          LocalDate departureDate);
}
