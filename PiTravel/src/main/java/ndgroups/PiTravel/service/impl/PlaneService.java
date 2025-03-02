package ndgroups.PiTravel.service.impl;

import jakarta.persistence.EntityNotFoundException;
import ndgroups.PiTravel.model.Plane;
import ndgroups.PiTravel.repository.PlaneRepository;
import ndgroups.PiTravel.service.Interface.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlaneService implements IPlaneService {
    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public Plane addPlane(Plane plane){
        return planeRepository.save(plane);
    }
    @Override
    public Plane getPlaneById(Integer id) {
        return planeRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Plane not found with id: " + id));
    }

    @Override
    public Plane updatePlane(Integer planeId, Plane plane) {
        return null;
    }

    @Override
    public void deletePlane(Integer id) {
        if (!planeRepository.existsById(id)) {
            throw new EntityNotFoundException("Plane not found with id: " + id);
        }
        planeRepository.deleteById(id);
    }
    @Override
    public List<Plane> getAllPlanes()  {
        return planeRepository.findAll();
    }

    @Override
    public List<Plane> getAllAvailablePlanes() {
        return null;
    }

    @Override
    public List<Plane> findAvailablePlanesByOriginAndDestinationAndDepartureDate(String origin, String destination,
                                                                                 LocalDate departureDate){
        return planeRepository.findAvailablePlanesByOriginAndDestinationAndDepartureDate(origin, destination,
                departureDate);
    }
}
