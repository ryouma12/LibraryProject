package com.example.finalproject.service;

import com.example.finalproject.Dto.ItemLoanIDto;
import com.example.finalproject.Dto.ItemNoteDto;
import com.example.finalproject.Dto.request.ItemLoanRequest;
import com.example.finalproject.Dto.request.ItemNoteRequest;
import com.example.finalproject.Model.ItemNote;

import java.util.List;

public interface ItemNoteService {
    ItemNoteDto getItemNoteById(Long id);
    ItemNote saveItemNote(ItemNoteRequest itemNoteRequest);
    ItemNote updateItemNote(ItemNoteRequest itemNoteRequest);
    List<ItemNoteDto> getAll();
    void deleteById(Long id);
}
