package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.ApiResponse;
import com.bms.bms_backend.dto.CreateShowRequest;
import com.bms.bms_backend.dto.ShowResponse;
import com.bms.bms_backend.model.Show;
import com.bms.bms_backend.service.ShowService;
import com.bms.bms_backend.service.ShowServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("bms/v1/shows")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;
    @PostMapping
    ResponseEntity<ApiResponse<ShowResponse>> addShow(@Valid @RequestBody CreateShowRequest request) {
        ApiResponse<ShowResponse> response = ApiResponse.<ShowResponse>builder()
                .status("SUCCESS")
                .message("Show added successfully")
                .data(showService.addShow(request))
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    List<ShowResponse> getAllShows(){
        return showService.getAllShows();
    }
    @GetMapping("/{id}")
    ShowResponse getShowById(@PathVariable Long id) {
        return showService.getShowById(id);
    }
}
