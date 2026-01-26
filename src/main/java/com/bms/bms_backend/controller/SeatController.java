package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.ApiResponse;
import com.bms.bms_backend.dto.CreateSeatRequest;
import com.bms.bms_backend.dto.SeatResponse;
import com.bms.bms_backend.model.Seat;
import com.bms.bms_backend.service.SeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("bms/v1/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatSerive;
    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<ApiResponse<SeatResponse>> addSeat(@Valid @RequestBody CreateSeatRequest request) {
        ApiResponse<SeatResponse> response = ApiResponse.<SeatResponse> builder()
                .status("SUCCESS")
                .message("Seat added successfully")
                .data(seatService.addSeat(request))
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        return seatSerive.addSeat(request);
    }
    @GetMapping
    public List<SeatResponse> getAllSeats(){
        return seatSerive.getAllSeats();
    }
    @GetMapping("/{id}")
    public SeatResponse getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id);
    }
}
