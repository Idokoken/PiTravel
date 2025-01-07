package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.Exception.ResourceNotFoundException;
import ndgroups.PiTravel.model.Booking;
import ndgroups.PiTravel.model.Plane;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.repository.BookingRepository;
import ndgroups.PiTravel.repository.PlaneRepository;
import ndgroups.PiTravel.repository.UserRepository;
import ndgroups.PiTravel.service.Interface.IBookingService;
import ndgroups.PiTravel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlaneRepository planeRepository;


   @Override
    public Booking saveBooking(Integer planeId, Integer userId, Booking bookingRequest) {
        Booking booking = new Booking();
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found"));
            Plane plane = planeRepository.findById(planeId).orElseThrow(() -> new ResourceNotFoundException("user not found"));

            bookingRequest.setPlane(plane);
            bookingRequest.setUser(user);
            String bookingConfirmationCode = Utils.generateRandomConfirmationCode(10);
            bookingRequest.setBookingConfirmationCode(bookingConfirmationCode);
            booking = bookingRepository.save(bookingRequest);

        }catch (Exception e){
            throw new IllegalArgumentException("Error saving the booking " + e.getMessage());
        }
        return booking;
    }

    @Override
    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("no booking with the given id: " + id));
    }

    @Override
    public Booking findBookingByConfirmationCode(String confirmationCode) {
        Booking booking = bookingRepository.findByBookingConfirmationCode(confirmationCode).
                orElseThrow(() -> new ResourceNotFoundException("booking not found"));
        return booking;

    }
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void cancelBooking(Integer id) {
        if(!bookingRepository.existsById(id)) {
            throw new IllegalArgumentException("no booking with the id of" + id);
        }
        bookingRepository.deleteById(id);
    }





//    private boolean roomIsAvailable(Booking bookingRequest, List<Booking> existingBookings) {
//        return existingBookings.stream().noneMatch(existingBooking ->
//                bookingRequest.getCheckInDate().equals(existingBooking.getCheckInDate())
//
//                        || bookingRequest.getCheckOutDate().isBefore(existingBooking.getCheckOutDate())
//                        || (bookingRequest.getCheckInDate().isAfter(existingBooking.getCheckInDate())
//                        && bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckOutDate()))
//                        || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())
//
//                        && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckOutDate()))
//                        || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())
//
//                        && bookingRequest.getCheckOutDate().isAfter(existingBooking.getCheckOutDate()))
//
//                        || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
//                        && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckInDate()))
//
//                        || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
//                        && bookingRequest.getCheckOutDate().equals(bookingRequest.getCheckInDate()))
//        );
//    }
//
}
