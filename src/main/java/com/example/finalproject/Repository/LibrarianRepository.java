package com.example.finalproject.Repository;

import com.example.finalproject.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    Librarian getLibrarianById(Long id);
}
