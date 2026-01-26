package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.CreateScreenRequest;
import com.bms.bms_backend.dto.ScreenResponse;
import com.bms.bms_backend.service.ScreenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bms/v1/screens")
@RequiredArgsConstructor
public class ScreenController {
    private final ScreenService screenService;
    @PostMapping
    public ScreenResponse addScreen(@Valid @RequestBody CreateScreenRequest request) {
        return screenService.addScreen(request);
    }
    @GetMapping
    public List<ScreenResponse> getAllScreens(){
        return screenService.getAllScreens();
    }
    @GetMapping("/{id}")
    public ScreenResponse getScreenById(@PathVariable Long id){
        return screenService.getScreenById(id);
    }
}
