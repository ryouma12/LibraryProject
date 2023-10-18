package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.StateDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.StateRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.State;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StateMapper {
    State toEntity(StateRequest stateRequest);
    StateDto toDto(State state);
    State toEntity(StateDto stateDto);
    List<StateDto> toDto(List<State> states);
    List<State> toEntity(List<StateDto> stateDtos);
}
