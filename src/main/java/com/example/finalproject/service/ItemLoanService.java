package com.example.finalproject.service;

import com.example.finalproject.Dto.ItemLoanIDto;
import com.example.finalproject.Dto.request.ItemLoanRequest;
import com.example.finalproject.Model.ItemLoan;

import java.util.List;

public interface ItemLoanService {
    ItemLoanIDto getItemLoanById(Long id);
    ItemLoan saveItemLoan(ItemLoanRequest itemLoanRequest);
    ItemLoan updateItemLoan(ItemLoanRequest itemLoanRequest);
    List<ItemLoanIDto> getAll();
    void deleteById(Long id);
}
