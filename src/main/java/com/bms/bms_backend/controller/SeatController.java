package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.CreateSeatRequest;
import com.bms.bms_backend.dto.SeatResponse;
import com.bms.bms_backend.service.SeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bms/v1/seats")
@RequiredArgsConstructor
public class SeatController {
    private final SeatService seatSerive;
    private final SeatService seatService;

    @PostMapping
    public SeatResponse addSeat(@Valid @RequestBody CreateSeatRequest request) {
        return seatSerive.addSeat(request);
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
