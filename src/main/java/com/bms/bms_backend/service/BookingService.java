package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.BookingResponse;
import com.bms.bms_backend.dto.CreateBookingRequest;

import java.util.List;

public interface BookingService {
    BookingResponse createBooking(CreateBookingRequest request);
    List<BookingResponse> getAllBookings();
    BookingResponse getBookingById(Long Id);
}
