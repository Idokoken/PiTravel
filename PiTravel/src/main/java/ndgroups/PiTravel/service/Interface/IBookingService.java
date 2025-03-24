package ndgroups.PiTravel.service.Interface;


import ndgroups.PiTravel.model.Booking;
import ndgroups.PiTravel.model.Plane;

import java.util.List;

public interface IBookingService {
    Booking saveBooking(Integer planeId, Integer userId, Booking bookingRequest);
    Booking getBookingById(Integer id);
    Booking updateBooking(Integer bookingId, Booking booking);
    void cancelBooking(Integer bookingId);
    List<Booking> getAllBookings();
    Booking findBookingByConfirmationCode(String confirmationCode);
    Booking findBookingBySeatNumber(Integer seatNumber);
    List<Booking> findBookingsByPlane(Integer planeId);
    List<Booking> findBookingsByUserId(Integer userId);



}
