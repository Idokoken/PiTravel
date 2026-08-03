package ndgroups.PiTravel.repository;

import ndgroups.PiTravel.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository  extends JpaRepository<City, Integer> {
    boolean existsByCityCode(String cityCode);
    boolean existsByCityCodeAndIdNot(String cityCode, Integer id);
    Page<City> findByCountryCode(String countryCode, Pageable pageable);
    @Query("""
             select c from City c
                Where lower(c.name) like lower(concat('%', :keyword, '%'))
                  or lower(c.cityCode) like lower(concat('%', :keyword, '%'))
                  or lower(c.countryCode) like lower(concat('%', :keyword, '%'))
                  or lower(c.countryName) like lower(concat('%', :keyword, '%'))
                  or lower(c.regionCode) like lower(concat('%', :keyword, '%'))
            """)
    Page<City>searchByKeyword(String keyword, Pageable pageable);
}
