package ndgroups.PiTravel.repository;

import ndgroups.PiTravel.Enum.FLIGHT_STATUS;
import ndgroups.PiTravel.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    boolean existsByFlightNumber(String flightNumber);
    boolean existsByFlightNumberAndIdNot(String flightNumber, Integer id);
    List<Flight> findByFlightStatus(FLIGHT_STATUS status);
    @Query("""
             select f from Flight f 
                Where :depId is null or f.departureAirportId = :depId
                and (:arrId is null or f.arrivalAirportId = :arrId)
            """)
    Page<Flight> findByByDepartureAirportIdAndArrivalAirportId(@Param("depId") Integer departureAirportId,
                                                               @Param("arrId") Integer arrivalAirportId,
                                                               Pageable pageable);
}
