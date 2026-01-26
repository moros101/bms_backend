package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateSeatRequest;
import com.bms.bms_backend.dto.SeatResponse;
import com.bms.bms_backend.model.Screen;
import com.bms.bms_backend.model.Seat;
import com.bms.bms_backend.repository.ScreenRepository;
import com.bms.bms_backend.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {
    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;

    @Override
    public SeatResponse addSeat(CreateSeatRequest request) {
        Long screenId = request.getScreenId();
        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found with screenId : " + screenId ));

        Seat seat = Seat.builder()
                .seatNumber(request.getSeatNumber())
                .seatType(request.getSeatType())
                .available(request.isAvailable())
                .screen(screen)
                .build();

        Seat saved = seatRepository.save(seat);
        return convert(saved);
    }
    @Override
    public List<SeatResponse> getAllSeats() {
        return seatRepository.findAll().stream()
                .map(this::convert)
                .toList();
    }
    @Override
    public SeatResponse getSeatById(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException( "Seat does not exist with id : " + id));
        return convert(seat);
    }

    private SeatResponse convert(Seat seat) {
        return SeatResponse.builder()
                .id(seat.getId())
                .seatNumber(seat.getSeatNumber())
                .seatType(seat.getSeatType().name())
                .available(seat.isAvailable())
                .screenId(seat.getScreen().getId())
                .screenName(seat.getScreen().getName())
                .build();
    }
}
