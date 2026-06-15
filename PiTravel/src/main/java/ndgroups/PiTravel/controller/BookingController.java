package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.Booking;
import ndgroups.PiTravel.response.APIResponse;
import ndgroups.PiTravel.service.Interface.IBookingService;
import ndgroups.PiTravel.service.Interface.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<APIResponse> createBooking(@PathVariable Integer planeId, @PathVariable Integer userId,
                                                     @RequestBody Booking bookingRequest){
        try {
            Booking booking = bookingService.saveBooking(planeId, userId, bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new APIResponse("booking successful", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping
//    @PreAuthorize("hasAuthority(ADMIN)")
    public ResponseEntity<APIResponse> geAllBooking(Model model) {
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", bookings));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getBookingById(@PathVariable Integer id) {
        try {
            Booking booking = bookingService.getBookingById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/code")
    public ResponseEntity<APIResponse> getByConfirmationCode(@RequestParam String code) {
        try {
            Booking booking = bookingService.findBookingByConfirmationCode(code);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/seat")
    public ResponseEntity<APIResponse> getBySeatNumber(@RequestParam Integer id) {
        try {
            Booking booking = bookingService.findBookingBySeatNumber(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/plane")
    public ResponseEntity<APIResponse> getBookingsByPlane(@RequestParam Integer planeId) {
        try {
           List<Booking> bookings = bookingService.findBookingsByPlane(planeId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", bookings));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/user")
    public ResponseEntity<APIResponse> getBookingsByUserId(@RequestParam Integer userId) {
        try {
            List<Booking> bookings = bookingService.findBookingsByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", bookings));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

        @GetMapping("/update/{id}")
    public ResponseEntity<APIResponse> updateBooking(@PathVariable Integer id, @RequestBody Booking bookingRequest) {
        try {
            Booking booking = bookingService.updateBooking(id, bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new APIResponse("successfully updated", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }


    @GetMapping("/cancel/{bookingId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<APIResponse> cancelBooking(@PathVariable Integer bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new APIResponse("successful", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new APIResponse(e.getMessage(), null));
        }
    }

}
