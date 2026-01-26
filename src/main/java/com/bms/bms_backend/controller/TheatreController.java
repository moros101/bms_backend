package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.ApiResponse;
import com.bms.bms_backend.dto.CreateTheatreRequest;
import com.bms.bms_backend.dto.TheatreResponse;
import com.bms.bms_backend.service.TheatreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.DoubleStream.builder;

@RestController
@RequestMapping("/bms/v1/theatres")
@RequiredArgsConstructor
public class TheatreController {
    private final TheatreService theatreService;

    @PostMapping
    public ResponseEntity<ApiResponse<TheatreResponse>> addTheatre(@Valid @RequestBody CreateTheatreRequest request){
        ApiResponse<TheatreResponse> response = ApiResponse.<TheatreResponse>builder()
                .status("SUCCESS")
                .message("Theatre added successfully")
                .data(theatreService.addTheatre(request))
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<TheatreResponse> getAllTheatres(){
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public TheatreResponse getTheatreById(@PathVariable Long id){
        return theatreService.getTheatreById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TheatreResponse>> updateTheatre(@PathVariable Long id, @Valid @RequestBody CreateTheatreRequest request){
        ApiResponse<TheatreResponse> response = ApiResponse.<TheatreResponse> builder()
                .status("SUCCESS")
                .message("Theatre updated successfully")
                .data(theatreService.updateTheatre(id, request))
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
//        return theatreService.updateTheatre(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteTheatre(@PathVariable Long id){
        theatreService.deleteTheatre(id);
        return "Theatre removed successfully!";
    }
}
