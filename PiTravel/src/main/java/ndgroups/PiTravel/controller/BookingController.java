package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.Booking;
import ndgroups.PiTravel.service.Interface.IBookingService;
import ndgroups.PiTravel.service.Interface.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/bookings")
public class BookingController {
    @Autowired
    private IBookingService bookingService;
    @Autowired
    private IPlaneService planeService;


    //    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{planeId}/{userId}")
    public String createBooking(@PathVariable Integer planeId, @PathVariable Integer userId,
                                @ModelAttribute("booking") Booking booking, Model model){
        bookingService.saveBooking(planeId, userId, booking);
        return "admin/bookings/checkout";
    }

    @GetMapping
//    @PreAuthorize("hasAuthority(ADMIN)")
    public String getBooking(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("booking", bookings);
        return "admin/bookings/bookingList";
    }
    @GetMapping("/code/{code}")
    public String getByConfirmationCode(@PathVariable String code) {
        Booking booking = bookingService.findBookingByConfirmationCode(code);
        return "admin/bookings/searchCode";
    }
    @GetMapping("/cancel/{bookingId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String cancelBooking(@PathVariable Integer bookingId) {
        bookingService.cancelBooking(bookingId);
        return "redirect:/bookings/all";
    }

}
