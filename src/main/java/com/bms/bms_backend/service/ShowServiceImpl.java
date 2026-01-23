package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateShowRequest;
import com.bms.bms_backend.dto.ShowResponse;
import com.bms.bms_backend.model.Movie;
import com.bms.bms_backend.model.Screen;
import com.bms.bms_backend.model.Show;
import com.bms.bms_backend.repository.MovieRepository;
import com.bms.bms_backend.repository.ScreenRepository;
import com.bms.bms_backend.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    @Override
    public ShowResponse addShow(CreateShowRequest request) {
        Long movieId = request.getMovieId();
        Long screenId = request.getScreenId();
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found with id : " + movieId));
        Screen screen = screenRepository.findById(screenId)
                .orElseThrow(() -> new RuntimeException("Screen not found with id : " + screenId));

        Show show = Show.builder()
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .price(request.getPrice())
                .movie(movie)
                .screen(screen)
                .build();
        Show saved = showRepository.save(show);
        return convert(saved);
    }
    @Override
    public List<ShowResponse> getAllShows(){
        return showRepository.findAll().stream()
                .map(this::convert)
                .toList();
    }
    @Override
    public ShowResponse getShowById(Long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found with id : " + id));
        return convert(show);
    }

    private ShowResponse convert(Show show) {
        return ShowResponse.builder()
                .id(show.getId())
                .startTime(show.getStartTime())
                .endTime(show.getEndTime())
                .price(show.getPrice())
                .movieName(show.getMovie().getTitle())
                .screenName(show.getScreen().getName())
                .build();
    }
}
