package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.CreateMovieRequest;
import com.bms.bms_backend.dto.MovieResponse;
import com.bms.bms_backend.model.Movie;
import com.bms.bms_backend.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bms/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public MovieResponse createMovie(@Valid @RequestBody CreateMovieRequest request){
        return movieService.createMovie(request);
    }

    @GetMapping
    public List<MovieResponse> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieResponse getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    public MovieResponse updateMovie(@PathVariable Long id, @Valid @RequestBody CreateMovieRequest request){
        return movieService.updateMovie(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return "Movie deleted successfully!";
    }
}
