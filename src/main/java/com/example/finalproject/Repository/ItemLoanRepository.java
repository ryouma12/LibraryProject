package com.example.finalproject.Repository;

import com.example.finalproject.Model.ItemLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemLoanRepository extends JpaRepository<ItemLoan, Long> {
    ItemLoan getItemLoansById(Long id);

}
