package com.example.finalproject.Repository;

import com.example.finalproject.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    Branch getBranchesById(Long id);
}
