package com.bms.bms_backend.service;

import com.bms.bms_backend.dto.CreateMovieRequest;
import com.bms.bms_backend.dto.MovieResponse;
import com.bms.bms_backend.model.Movie;
import com.bms.bms_backend.repository.MovieRepository;
import com.bms.bms_backend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements  MovieService {
    private final MovieRepository movieRepository;

    @Override
    public MovieResponse createMovie(CreateMovieRequest request){
        Movie movie = Movie.builder()
                .title(request.getTitle())
                .language(request.getLanguage())
                .genre(request.getGenre())
                .duration(request.getDuration())
                .build();

        Movie saved = movieRepository.save(movie);
        return convertToResponse(saved);
    }

    @Override
    public List<MovieResponse> getAllMovies(){
        return movieRepository.findAll().stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    @Cacheable(value = "movies", key = "#id")
    public MovieResponse getMovieById(Long id){
        simulateSlowService();
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No movie found for id :" + id));
        return convertToResponse(movie);
    }

    @Override
    public MovieResponse updateMovie(Long id, CreateMovieRequest request){
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No movie found for id :" + id));

        // update fields
        existingMovie.setTitle(request.getTitle());
        existingMovie.setLanguage(request.getLanguage());
        existingMovie.setGenre(request.getGenre());
        existingMovie.setDuration(request.getDuration());

        Movie saved = movieRepository.save(existingMovie);
        return convertToResponse(saved);
    }

    @Override
    @CacheEvict(value = "movies", key = "#id")
    public void deleteMovie(Long id){
        if(!movieRepository.existsById(id)){
            throw new RuntimeException("Movie not found with id : " + id);
        }
        movieRepository.deleteById(id);
    }

    private MovieResponse convertToResponse(Movie movie){
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .language(movie.getLanguage())
                .genre(movie.getGenre())
                .duration(movie.getDuration())
                .build();
    }

    private void simulateSlowService() {
        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
