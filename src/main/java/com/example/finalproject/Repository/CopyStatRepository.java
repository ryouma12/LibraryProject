package com.example.finalproject.Repository;

import com.example.finalproject.Model.CopyStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyStatRepository extends JpaRepository<CopyStat, Long> {
    CopyStat  getCopyStatById(Long id);
}
