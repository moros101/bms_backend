package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.CreateShowRequest;
import com.bms.bms_backend.dto.ShowResponse;
import com.bms.bms_backend.service.ShowService;
import com.bms.bms_backend.service.ShowServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bms/v1/shows")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;
    @PostMapping
    ShowResponse addShow(@RequestBody CreateShowRequest request) {
        return showService.addShow(request);
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
