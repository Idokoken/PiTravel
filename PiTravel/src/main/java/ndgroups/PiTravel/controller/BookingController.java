package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.Booking;
import ndgroups.PiTravel.model.Plane;
import ndgroups.PiTravel.response.ApiResponse;
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
    public ResponseEntity<ApiResponse> createBooking(@PathVariable Integer planeId, @PathVariable Integer userId,
                                @RequestBody Booking bookingRequest){
        try {
            Booking booking = bookingService.saveBooking(planeId, userId, bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("booking successful", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping
//    @PreAuthorize("hasAuthority(ADMIN)")
    public ResponseEntity<ApiResponse> geAllBooking(Model model) {
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", bookings));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getBookingById(@PathVariable Integer id) {
        try {
            Booking booking = bookingService.getBookingById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/code")
    public ResponseEntity<ApiResponse> getByConfirmationCode(@RequestParam String code) {
        try {
            Booking booking = bookingService.findBookingByConfirmationCode(code);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/seat")
    public ResponseEntity<ApiResponse> getBySeatNumber(@RequestParam Integer id) {
        try {
            Booking booking = bookingService.findBookingBySeatNumber(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/plane")
    public ResponseEntity<ApiResponse> getBookingsByPlane(@RequestParam Integer planeId) {
        try {
           List<Booking> bookings = bookingService.findBookingsByPlane(planeId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", bookings));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }
    @GetMapping("/user")
    public ResponseEntity<ApiResponse> getBookingsByUserId(@RequestParam Integer userId) {
        try {
            List<Booking> bookings = bookingService.findBookingsByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", bookings));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

        @GetMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateBooking(@PathVariable Integer id, @RequestBody Booking bookingRequest) {
        try {
            Booking booking = bookingService.updateBooking(id, bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse("successfully updated", booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }


    @GetMapping("/cancel/{bookingId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> cancelBooking(@PathVariable Integer bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse("successful", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

}
