package ndgroups.PiTravel.repository;

import ndgroups.PiTravel.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
    Airport findByIataCode(String iataCode);
    List<Airport>findByCityId(Integer id);
    boolean existsByIataCode(String iataCode);
}
