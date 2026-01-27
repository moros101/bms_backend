package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.ApiResponse;
import com.bms.bms_backend.dto.BookingResponse;
import com.bms.bms_backend.dto.CreateBookingRequest;
import com.bms.bms_backend.repository.BookingRepository;
import com.bms.bms_backend.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("bms/v1/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    private final BookingRepository bookingRepository;

    @PostMapping
    public ResponseEntity<ApiResponse<BookingResponse>> createBooking(@Valid @RequestBody CreateBookingRequest request) {
//        return bookingService.createBooking(request);
        ApiResponse<BookingResponse> response = ApiResponse.<BookingResponse> builder()
                .status("SUCCESS")
                .message("Booking created successfully")
                .data(bookingService.createBooking(request))
                .timeStamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public List<BookingResponse> getAllBookings() {
        return bookingService.getAllBookings();
    }
    @GetMapping("/{id}")
    public BookingResponse getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/countBookingPerMovie")
    public List<Object[]> countBookingPerMovie(){
        return bookingRepository.countBookingPerMovieJPQL();
    }
}
