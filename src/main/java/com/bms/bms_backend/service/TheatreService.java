package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateTheatreRequest;
import com.bms.bms_backend.dto.TheatreResponse;

import java.util.List;

public interface TheatreService {
    TheatreResponse addTheatre(CreateTheatreRequest request);
    List<TheatreResponse> getAllTheatres();
    TheatreResponse getTheatreById(Long id);
    TheatreResponse updateTheatre(Long id, CreateTheatreRequest request);
    void deleteTheatre(Long id);
}
