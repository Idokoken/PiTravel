package ndgroups.PiTravel.service.impl;

import ndgroups.PiTravel.Exception.ResourceNotFoundException;
import ndgroups.PiTravel.model.Booking;
import ndgroups.PiTravel.model.Aircraft;
import ndgroups.PiTravel.model.User;
import ndgroups.PiTravel.repository.BookingRepository;
import ndgroups.PiTravel.repository.AircraftRepository;
import ndgroups.PiTravel.repository.UserRepository;
import ndgroups.PiTravel.security.utils.Utils;
import ndgroups.PiTravel.service.Interface.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AircraftRepository aircraftRepository;


   @Override
    public Booking saveBooking(Integer planeId, Integer userId, Booking bookingRequest) {
        Booking booking = new Booking();
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found"));
            Aircraft aircraft = aircraftRepository.findById(planeId).orElseThrow(() -> new ResourceNotFoundException("user not found"));

            bookingRequest.setAircraft(aircraft);
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
                orElseThrow(() -> new ResourceNotFoundException("no booking with the given id: " + id));
    }

    @Override
    public Booking updateBooking(Integer bookingId, Booking booking) {
        Optional<Booking> optBooking = bookingRepository.findById(bookingId);
        if(optBooking.isPresent()){
            Booking existingBooking  =  optBooking.get();
            existingBooking.setTotalAmount(booking.getTotalAmount());
            existingBooking.setSeatNumber(booking.getSeatNumber());

            return bookingRepository.save(existingBooking);
        }
        throw new ResourceNotFoundException("Booking with booking id not found " + bookingId);
    }

    @Override
    public Booking findBookingByConfirmationCode(String confirmationCode) {
        return bookingRepository.findByBookingConfirmationCode(confirmationCode).
                orElseThrow(() -> new ResourceNotFoundException("booking not found"));

    }

    @Override
    public Booking findBookingBySeatNumber(Integer seatNumber) {
        return bookingRepository.findBySeatNumber(seatNumber).
                orElseThrow(() -> new ResourceNotFoundException("booking not found"));
    }

    @Override
    public List<Booking> findBookingsByAircraft(Integer planeId) {
       Optional<Aircraft> plane  = aircraftRepository.findById(planeId);
        return bookingRepository.findByAircraft(plane.get());
    }

    @Override
    public List<Booking> findBookingsByUserId(Integer userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void cancelBooking(Integer id) {
        if(!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("no booking with the id of" + id);
        }
        bookingRepository.deleteById(id);
    }




}
