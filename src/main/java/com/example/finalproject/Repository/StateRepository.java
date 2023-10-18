package com.example.finalproject.Repository;

import com.example.finalproject.Model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    State getStateById(Long id);
}
