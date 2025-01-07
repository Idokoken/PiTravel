package ndgroups.PiTravel.service.Interface;


import ndgroups.PiTravel.model.Booking;

import java.util.List;

public interface IBookingService {
    Booking saveBooking(Integer planeId, Integer userId, Booking bookingRequest);
    Booking getBookingById(Integer id);
    Booking findBookingByConfirmationCode(String confirmationCode);
    List<Booking> getAllBookings();
    void cancelBooking(Integer bookingId);

}
