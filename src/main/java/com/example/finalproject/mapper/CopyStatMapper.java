package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.CopyStatDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.CopyStatRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.CopyStat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CopyStatMapper {
    CopyStat toEntity(CopyStatRequest copyStatRequest);
    CopyStatDto toDto(CopyStat copyStat);
    CopyStat toEntity(CopyStatDto copyStatDto);
    List<CopyStatDto> toDto(List<CopyStat> copyStats);
    List<CopyStat> toEntity(List<CopyStatDto> copyStatDtos);
}
