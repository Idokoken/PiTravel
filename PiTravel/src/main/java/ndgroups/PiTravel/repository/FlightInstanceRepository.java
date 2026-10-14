package ndgroups.PiTravel.repository;

import ndgroups.PiTravel.model.FlightInstance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightInstanceRepository extends JpaRepository<FlightInstance, Integer> {
//    @Query("""
//             select fi from FlightInstance fi
//                Where :departureAirportId is null or f.departureAirportId = :departureAirportId
//                and (:arrivalAirportId is null or f.arrivalAirportId = :arrivalAirportId)
//                and (:dayStart is null or f.departureDateTime >= :dayStart)
//                and (:dayEnd is null or f.arrivalDateTime <= :dayEnd)
//            """)
//    Page<FlightInstance> findAllInstance(@Param("departureAirportId") Integer departureAirportId,
//                                         @Param("arrivalAirportId") Integer arrivalAirportId,
//                                         @Param("dayStart") LocalDateTime dayStart,
//                                         @Param("dayEnd") LocalDateTime dayEnd,
//                                         Pageable pageable);
}
