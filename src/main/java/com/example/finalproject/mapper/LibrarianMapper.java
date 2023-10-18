package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.LibrarianDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.LibrarianRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.Librarian;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibrarianMapper {
    Librarian toEntity(LibrarianRequest librarianRequest);
    LibrarianDto toDto(Librarian librarian);
    Librarian toEntity(LibrarianDto librarianDto);
    List<LibrarianDto> toDto(List<Librarian> librarians);
    List<Librarian> toEntity(List<LibrarianDto> librarianDtos);
}
