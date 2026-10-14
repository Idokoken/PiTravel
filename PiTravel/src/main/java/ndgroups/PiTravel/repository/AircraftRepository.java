package ndgroups.PiTravel.repository;

import jakarta.validation.constraints.NotBlank;
import ndgroups.PiTravel.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {

    Aircraft findByCode(String code);
    boolean existsByCode(String code);
    List<Aircraft>findByAircraftName(String aircraftName);
    List<Aircraft> findByCurrentAirportId(Integer id);

    boolean existsByCodeAndIdNot(String code, Integer id);
//    List<Aircraft>findByDepartureDate(LocalDate departureDate);
//    List<Aircraft>findByDestination(String destination);
//    @Query("SELECT t FROM Aircraft t WHERE " +
//            "t.departureDate = :departureDate AND " +
//            "(t.origin = :origin OR :origin IS NULL OR :origin = '' OR t.origin IS NOT NULL) AND " +
//            "(t.destination = :destination OR :destination IS NULL OR :destination = '' OR t.destination IS NOT NULL)")
//    List<Aircraft> findAvailableAircraftByOriginAndDestinationAndDepartureDate(
//            @Param("origin") String origin,
//            @Param("destination") String destination,
//            @Param("departureDate") LocalDate departureDate
//    );

//    @Query("SELECT e FROM Aircraft e WHERE e.departureDate >= :today")
//    List<Aircraft> findAvailableAircraft(LocalDate today);
}

