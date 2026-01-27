package com.bms.bms_backend.repository;

import com.bms.bms_backend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b.show.movie.title, COUNT(b) FROM Booking b GROUP BY b.show.movie.title")
    List<Object[]> countBookingPerMovieJPQL();

    @Query(value = "SELECT m.title, COUNT(b.id)" +
            " FROM bookings b " +
            "JOIN shows s ON b.show_id = s.id " +
            "JOIN movies m ON s.movie_id = m.id " +
            "GROUP BY m.title", nativeQuery = true)
    List<Object[]> countBookingPerMovieNative();
}
