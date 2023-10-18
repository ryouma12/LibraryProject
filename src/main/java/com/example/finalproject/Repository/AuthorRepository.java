package com.example.finalproject.Repository;

import com.example.finalproject.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getAuthorById(Long id);
}
