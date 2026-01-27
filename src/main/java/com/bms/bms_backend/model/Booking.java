package com.bms.bms_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    // n booking - 1 user
    // n booking - 1 show
    // n booking - n seats
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime bookingTime;
    private String status;
    private double totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "booking_seats",
                joinColumns = @JoinColumn(name = "booking_id"),
                inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;

}
