package com.example.finalproject.service;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Model.Author;

import java.util.List;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

    Author saveAuthor (AuthorRequest authorRequest);

    Author updateAuthor (AuthorRequest authorRequest);

    List<AuthorDto> getAll();

    void deleteById(Long id);
}
