package com.example.finalproject.Repository;

import com.example.finalproject.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    SubjectRepository getSubjectById(Long id);
}
