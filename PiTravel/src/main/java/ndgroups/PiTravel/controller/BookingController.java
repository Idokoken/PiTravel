package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.model.Booking;
import ndgroups.PiTravel.response.ApiResponseDto;
import ndgroups.PiTravel.service.Interface.IBookingService;
import ndgroups.PiTravel.service.Interface.IAircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/bookings")
public class BookingController {
    @Autowired
    private IBookingService bookingService;
    @Autowired
    private IAircraftService aircraftService;


    //    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{aircraftId}/{userId}")
    public ResponseEntity<ApiResponseDto<Booking>> createBooking(@PathVariable Integer aircraftId,
                                                        @PathVariable Integer userId,
                                                     @RequestBody Booking bookingRequest){
        try {
            Booking booking = bookingService.saveBooking(aircraftId, userId, bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), booking,
                            "booking successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null,e.getMessage()));
        }
    }

    @GetMapping("/list")
//    @PreAuthorize("hasAuthority(ADMIN)")
    public ResponseEntity<ApiResponseDto<List<Booking>>> geAllBooking() {
        try {
            List<Booking> bookings = bookingService.getAllBookings();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), bookings,
                            "successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null,e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Booking>> getBookingById(@PathVariable Integer id) {
        try {
            Booking booking = bookingService.getBookingById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), booking,
                            "successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null,e.getMessage()));
        }
    }
    @GetMapping("/code")
    public ResponseEntity<ApiResponseDto<Booking>> getByConfirmationCode(@RequestParam String code) {
        try {
            Booking booking = bookingService.findBookingByConfirmationCode(code);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), booking,
                            "successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null,e.getMessage()));
        }
    }

    @GetMapping("/seat")
    public ResponseEntity<ApiResponseDto<Booking>> getBySeatNumber(@RequestParam Integer id) {
        try {
            Booking booking = bookingService.findBookingBySeatNumber(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), booking,
                            "successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null,e.getMessage()));
        }
    }

    @GetMapping("/aircraft")
    public ResponseEntity<ApiResponseDto<List<Booking>>> getBookingsByAircraft(@RequestParam Integer aircraftId) {
        try {
           List<Booking> bookings = bookingService.findBookingsByAircraft(aircraftId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), bookings,
                            "successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null,e.getMessage()));
        }
    }

    @GetMapping("/user")
    public ResponseEntity<ApiResponseDto<List<Booking>>> getBookingsByUserId(@RequestParam Integer userId) {
        try {
            List<Booking> bookings = bookingService.findBookingsByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true, HttpStatus.OK.value(), bookings,
                            "successful"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null, e.getMessage()));
        }
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<ApiResponseDto<Booking>> updateBooking(@PathVariable Integer id,
                                                        @RequestBody Booking bookingRequest) {
        try {
            Booking booking = bookingService.updateBooking(id, bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponseDto<>(true, HttpStatus.CREATED.value(), booking,
                            "successfully updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null,e.getMessage()));
        }
    }


    @GetMapping("/cancel/{bookingId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> cancelBooking(@PathVariable Integer bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponseDto<>(true,HttpStatus.OK.value(), null,
                            "booking successfully canceled"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponseDto<>(false, HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            null,e.getMessage()));
        }
    }

}
