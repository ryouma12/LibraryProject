package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.PerformerDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.PerformerRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.Performer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PerformerMapper {
    Performer toEntity(PerformerRequest performerRequest);
    PerformerDto toDto(Performer performer);
    Performer toEntity(PerformerDto performerDto);
    List<PerformerDto> toDto(List<Performer> performers);
    List<Performer> toEntity(List<PerformerDto> performerDtos);
}
