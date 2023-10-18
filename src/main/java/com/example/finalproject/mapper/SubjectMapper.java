package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.SubjectDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.SubjectRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    Subject toEntity(SubjectRequest subjectRequest);
    SubjectDto toDto(Subject subject);
    Subject toEntity(SubjectDto subjectDto);
    List<SubjectDto> toDto(List<Subject> subjects);
    List<Subject> toEntity(List<SubjectDto> subjectDtos);
}
