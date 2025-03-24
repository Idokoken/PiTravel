package ndgroups.PiTravel.repository;

import ndgroups.PiTravel.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {

    List<Plane>findByPlaneName(String planeName);
    List<Plane>findByDepartureDate(LocalDate departureDate);
    List<Plane>findByDestination(String destination);
    @Query("SELECT t FROM Plane t WHERE " +
            "t.departureDate = :departureDate AND " +
            "(t.origin = :origin OR :origin IS NULL OR :origin = '' OR t.origin IS NOT NULL) AND " +
            "(t.destination = :destination OR :destination IS NULL OR :destination = '' OR t.destination IS NOT NULL)")
    List<Plane> findAvailablePlanesByOriginAndDestinationAndDepartureDate(
            @Param("origin") String origin,
            @Param("destination") String destination,
            @Param("departureDate") LocalDate departureDate
    );

    @Query("SELECT e FROM Plane e WHERE e.departureDate >= :today")
    List<Plane> findAvailablePlanes(LocalDate today);
}
