package com.example.finalproject.service;

import com.example.finalproject.Dto.LibrarianDto;
import com.example.finalproject.Dto.PatronDto;
import com.example.finalproject.Dto.request.LibrarianRequest;
import com.example.finalproject.Dto.request.PatronRequest;
import com.example.finalproject.Model.Librarian;
import com.example.finalproject.Model.Patron;

import java.util.List;

public interface PatronService {
    PatronDto getPatronById(Long id);
    Patron savePatron(PatronRequest patronRequest);
    Patron updatePatron(PatronRequest patronRequest);
    List<PatronDto> getAll();
    void deleteById(Long id);
}
