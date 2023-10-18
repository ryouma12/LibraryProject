package com.example.finalproject.Repository;

import com.example.finalproject.Model.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerRepository extends JpaRepository<Performer, Long> {
    Performer getPerformerById(Long id);
}
