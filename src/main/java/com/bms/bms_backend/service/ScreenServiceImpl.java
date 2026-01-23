package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateScreenRequest;
import com.bms.bms_backend.dto.ScreenResponse;
import com.bms.bms_backend.model.Screen;
import com.bms.bms_backend.model.Theatre;
import com.bms.bms_backend.repository.ScreenRepository;
import com.bms.bms_backend.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenServiceImpl implements ScreenService {
    private final ScreenRepository screenRepository;
    private final TheatreRepository theatreRepository;

    @Override
    public ScreenResponse addScreen(CreateScreenRequest request){
        Long theatreId = request.getTheatreId();
        Theatre theatre = theatreRepository.findById(theatreId)
                .orElseThrow(() -> new RuntimeException("theatre not found with theatreId : " + theatreId));
        Screen screen = Screen.builder()
                .name(request.getName())
                .theatre(theatre)
                .build();

        Screen saved = screenRepository.save(screen);
        return convert(saved);
    }
    @Override
    public List<ScreenResponse>  getAllScreens(){
        return screenRepository.findAll().stream()
                .map(this:: convert)
                .toList();
    }
    @Override
    public ScreenResponse getScreenById(Long id){
        Screen screen = screenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Screen not found with id : " + id));
        return convert(screen);
    }
    private ScreenResponse convert(Screen screen){
        return ScreenResponse.builder()
                .id(screen.getId())
                .name(screen.getName())
                .theatreId(screen.getTheatre().getId())
                .theatreName(screen.getTheatre().getName())
                .build();
    }
}
