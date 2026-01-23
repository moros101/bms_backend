package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateTheatreRequest;
import com.bms.bms_backend.dto.TheatreResponse;
import com.bms.bms_backend.model.Theatre;
import com.bms.bms_backend.repository.TheatreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService {
    private final TheatreRepository theatreRepository;

    @Override
    public TheatreResponse addTheatre(CreateTheatreRequest request){
        Theatre theatre = Theatre.builder()
                .name(request.getName())
                .city(request.getCity())
                .address(request.getAddress())
                .build();
        Theatre saved = theatreRepository.save(theatre);
        return convertToResponse(saved);
    }
    @Override
    public List<TheatreResponse> getAllTheatres(){
        return theatreRepository.findAll().stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public TheatreResponse getTheatreById(Long id){
        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found with id : " + id));
        return convertToResponse(theatre);
    }

    @Override
    public TheatreResponse updateTheatre(Long id, CreateTheatreRequest request){
        Theatre existingTheatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Theatre not found with id : " + id));

        existingTheatre.setName(request.getName());
        existingTheatre.setCity(request.getCity());
        existingTheatre.setAddress(request.getAddress());

        Theatre updated = theatreRepository.save(existingTheatre);
        return convertToResponse(updated);
    }

    @Override
    public void deleteTheatre(Long id){
        if(!theatreRepository.existsById(id)){
            throw new RuntimeException("No theatre found with id : " + id);
        }
        theatreRepository.deleteById(id);
    }

    private TheatreResponse convertToResponse(Theatre theatre){
        return TheatreResponse.builder()
                .id(theatre.getId())
                .name(theatre.getName())
                .city(theatre.getCity())
                .address(theatre.getAddress())
                .build();
    }
}
