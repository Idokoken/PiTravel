package ndgroups.PiTravel.service.impl;

import jakarta.persistence.EntityNotFoundException;
import ndgroups.PiTravel.Exception.ResourceNotFoundException;
import ndgroups.PiTravel.model.Plane;
import ndgroups.PiTravel.repository.PlaneRepository;
import ndgroups.PiTravel.service.Interface.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        Optional<Plane> optionalPlane = planeRepository.findById(planeId);
        if(optionalPlane.isPresent()){
            Plane existingPlane = optionalPlane.get();
            existingPlane.setPlaneName(plane.getPlaneName());
            existingPlane.setOrigin(plane.getOrigin());
            existingPlane.setDestination(plane.getDestination());
            existingPlane.setDepartureDate(plane.getDepartureDate());
            existingPlane.setDepartureTime(plane.getDepartureTime());
            existingPlane.setAvailableSeats(plane.getAvailableSeats());
            existingPlane.setPrice(plane.getPrice());

            return planeRepository.save(existingPlane);
        }
       throw new ResourceNotFoundException("Plane with the given id not found " + planeId);
    }

    @Override
    public void deletePlane(Integer id) {
        if (!planeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Plane not found with id: " + id);
        }
        planeRepository.deleteById(id);
    }
    @Override
    public List<Plane> getAllPlanes()  {return planeRepository.findAll();
    }

    @Override
    public List<Plane> getAllAvailablePlanes() {
        return planeRepository.findAvailablePlanes(LocalDate.now());
    }

    @Override
    public List<Plane> getPlanesByPlaneName(String planeName) {
        return planeRepository.findByPlaneName(planeName);
    }

    @Override
    public List<Plane> getPlanesByDepartureDate(LocalDate departureDate) {
        return planeRepository.findByDepartureDate(departureDate);
    }

    @Override
    public List<Plane> getPlanesByDestination(String destination) {
        return planeRepository.findByDestination(destination);
    }

    @Override
    public List<Plane> findAvailablePlanesByOriginAndDestinationAndDepartureDate(String origin, String destination,
                                                                                 LocalDate departureDate){
        return planeRepository.findAvailablePlanesByOriginAndDestinationAndDepartureDate(origin, destination,
                departureDate);
    }
}
