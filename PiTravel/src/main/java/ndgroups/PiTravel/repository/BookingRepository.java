package ndgroups.PiTravel.repository;

import ndgroups.PiTravel.model.Booking;
import ndgroups.PiTravel.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Optional<Booking> findBySeatNumber(Integer seatNumber);
    List<Booking> findByPlane(Plane plane);
    Optional<Booking> findByBookingConfirmationCode(String confirmationCode);
    List<Booking>findByUserId(Integer userId);
}
