package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateMovieRequest;
import com.bms.bms_backend.dto.MovieResponse;
import com.bms.bms_backend.model.Movie;

import java.util.List;

public interface MovieService {
    MovieResponse createMovie(CreateMovieRequest request);
    List<MovieResponse> getAllMovies();
    MovieResponse getMovieById(Long id);
    MovieResponse updateMovie(Long id, CreateMovieRequest request);
    void deleteMovie(Long id);
}
