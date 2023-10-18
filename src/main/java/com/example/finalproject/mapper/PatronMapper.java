package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.PatronDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.PatronRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.Patron;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatronMapper {
    Patron toEntity(PatronRequest patronRequest);
    PatronDto toDto(Patron patron);
    Patron toEntity(PatronDto patronDto);
    List<PatronDto> toDto(List<Patron> patrons);
    List<Patron> toEntity(List<PatronDto> patronDtos);
}
