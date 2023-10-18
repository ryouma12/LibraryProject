package com.example.finalproject.Repository;

import com.example.finalproject.Model.ItemNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemNoteRepository extends JpaRepository<ItemNote, Long> {
    ItemNote getItemNotesById(Long id);
}
