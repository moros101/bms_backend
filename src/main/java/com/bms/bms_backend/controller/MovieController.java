package com.bms.bms_backend.controller;

import com.bms.bms_backend.dto.ApiResponse;
import com.bms.bms_backend.dto.CreateMovieRequest;
import com.bms.bms_backend.dto.MovieResponse;
import com.bms.bms_backend.model.Movie;
import com.bms.bms_backend.repository.MovieRepository;
import com.bms.bms_backend.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bms/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final MovieRepository movieRepository;

    @PostMapping
    public ResponseEntity<ApiResponse<MovieResponse>> createMovie(@Valid @RequestBody CreateMovieRequest request){
//        return movieService.createMovie(request);
        ApiResponse<MovieResponse> response = ApiResponse.<MovieResponse> builder()
                .status("SUCCESS")
                .message("Movie created successfully")
                .data(movieService.createMovie(request))
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
    public ResponseEntity<ApiResponse<MovieResponse>> updateMovie(@PathVariable Long id, @Valid @RequestBody CreateMovieRequest request){
//        return movieService.updateMovie(id, request);
        ApiResponse<MovieResponse> response = ApiResponse.<MovieResponse> builder()
                .status("SUCCESS")
                .message("Movie saved successfully")
                .data(movieService.updateMovie(id, request))
                .timeStamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return "Movie deleted successfully!";
    }

    @GetMapping("/search/{title}")
    public List<Movie> searchMovies(@PathVariable String title) {
        return movieRepository.searchMovieByTitleJPQL(title);
    }
}
