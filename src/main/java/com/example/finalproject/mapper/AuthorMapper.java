package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Model.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toEntity(AuthorRequest authorRequest);
    AuthorDto toDto(Author author);
    Author toEntity(AuthorDto authorDto);
    List<AuthorDto> toDto(List<Author> authors);
    List<Author> toEntity(List<AuthorDto> authorDtos);
}
