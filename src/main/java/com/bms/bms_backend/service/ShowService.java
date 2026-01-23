package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateShowRequest;
import com.bms.bms_backend.dto.ShowResponse;

import java.util.List;

public interface ShowService {
    ShowResponse addShow(CreateShowRequest request);
    List<ShowResponse> getAllShows();
    ShowResponse getShowById(Long Id);
}
