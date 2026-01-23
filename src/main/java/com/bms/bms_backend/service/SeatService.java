package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateSeatRequest;
import com.bms.bms_backend.dto.SeatResponse;

import java.util.List;

public interface SeatService {
    SeatResponse addSeat(CreateSeatRequest request);
    List<SeatResponse> getAllSeats();
    SeatResponse getSeatById(Long id);
}
