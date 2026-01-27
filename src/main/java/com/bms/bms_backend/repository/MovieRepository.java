package com.bms.bms_backend.repository;

import com.bms.bms_backend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // JPQL Example: using entity fields, not table columns
    @Query("SELECT m FROM Movie m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Movie> searchMovieByTitleJPQL(String title);

    // Corresponding Native query example — uses actual SQL and table/column names
    @Query(value = "SELECT * FROM movies WHERE LOWER(title) LIKE LOWER(CONCAT('%', :title, '%'))",nativeQuery = true)
    List<Movie> searchMovieByTitleNative(String title);
}
