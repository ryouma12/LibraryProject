package com.example.finalproject.Repository;

import com.example.finalproject.Model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher getPublisherById(Long id);
}
