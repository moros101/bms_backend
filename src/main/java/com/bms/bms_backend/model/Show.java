package com.bms.bms_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "shows")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double price;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    Screen screen;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;
}
