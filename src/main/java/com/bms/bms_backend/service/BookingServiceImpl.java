package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.BookingResponse;
import com.bms.bms_backend.dto.CreateBookingRequest;
import com.bms.bms_backend.dto.SeatResponse;
import com.bms.bms_backend.model.Booking;
import com.bms.bms_backend.model.Seat;
import com.bms.bms_backend.model.Show;
import com.bms.bms_backend.model.User;
import com.bms.bms_backend.repository.BookingRepository;
import com.bms.bms_backend.repository.SeatRepository;
import com.bms.bms_backend.repository.ShowRepository;
import com.bms.bms_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements  BookingService {
    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;

    public BookingResponse createBooking(CreateBookingRequest request) {
        Long showId = request.getShowId();
        Long userId = request.getUserId();
        List<Long> seatIds = request.getSeatIds();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id : " + userId));

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new RuntimeException("Show not found with id : " + showId));

        List<Seat> seats = seatRepository.findAllById(seatIds);

        double totalAmount = show.getPrice() * seats.size();

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .totalAmount(totalAmount)
                .bookingTime(LocalDateTime.now())
                .status("CONFIRMED")
                .build();


        Booking saved = bookingRepository.save(booking);
        return convert(saved);
    }
    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(this::convert).toList();
    }
    public BookingResponse getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking bot found by Id : " + id));
        return convert(booking);
    }
    private BookingResponse convert(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .userName(booking.getUser().getName())
                .movieTitle(booking.getShow().getMovie().getTitle())
                .screenName(booking.getShow().getScreen().getName())
                .seatNumbers(booking.getSeats().stream().map(Seat::getSeatNumber).toList())
                .totalAmount(booking.getTotalAmount())
                .status(booking.getStatus())
                .bookingTime(booking.getBookingTime())
                .build();
    }
}
