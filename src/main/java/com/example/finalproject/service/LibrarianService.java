package com.example.finalproject.service;

import com.example.finalproject.Dto.ItemTypeDto;
import com.example.finalproject.Dto.LibrarianDto;
import com.example.finalproject.Dto.request.ItemTypeRequest;
import com.example.finalproject.Dto.request.LibrarianRequest;
import com.example.finalproject.Model.ItemType;
import com.example.finalproject.Model.Librarian;

import java.util.List;

public interface LibrarianService {
    LibrarianDto getLibrarianById(Long id);
    Librarian saveLibrarian(LibrarianRequest librarianRequest);
    Librarian updateLibrarian(LibrarianRequest librarianRequest);
    List<LibrarianDto> getAll();
    void deleteById(Long id);
}
