package com.bms.bms_backend.repository;

import com.bms.bms_backend.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    @Query("SELECT s FROM Show s JOIN FETCH s.movie JOIN FETCH s.screen")
    List<Show> findAllShows();

}
