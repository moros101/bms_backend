package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.CreateTheatreRequest;
import com.bms.bms_backend.dto.TheatreResponse;
import com.bms.bms_backend.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bms/v1/theatres")
@RequiredArgsConstructor
public class TheatreController {
    private final TheatreService theatreService;

    @PostMapping
    public TheatreResponse addTheatre(@RequestBody CreateTheatreRequest request){
        return theatreService.addTheatre(request);
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
    public TheatreResponse updateTheatre(@PathVariable Long id, @RequestBody CreateTheatreRequest request){
        return theatreService.updateTheatre(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteTheatre(@PathVariable Long id){
        theatreService.deleteTheatre(id);
        return "Theatre removed successfully!";
    }
}
