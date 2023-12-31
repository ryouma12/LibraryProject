package com.example.finalproject.Repository;

import com.example.finalproject.Model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
    ItemType getItemTypesById(Long id);
}
