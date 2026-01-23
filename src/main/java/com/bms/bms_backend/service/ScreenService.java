package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateScreenRequest;
import com.bms.bms_backend.dto.ScreenResponse;

import java.util.List;

public interface ScreenService {
    ScreenResponse addScreen(CreateScreenRequest request);
    ScreenResponse getScreenById(Long id);
    List<ScreenResponse> getAllScreens();
}
