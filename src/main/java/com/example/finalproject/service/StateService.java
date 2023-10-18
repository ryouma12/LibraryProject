package com.example.finalproject.service;

import com.example.finalproject.Dto.PublisherDto;
import com.example.finalproject.Dto.StateDto;
import com.example.finalproject.Dto.request.PublisherRequest;
import com.example.finalproject.Dto.request.StateRequest;
import com.example.finalproject.Model.Publisher;
import com.example.finalproject.Model.State;

import java.util.List;

public interface StateService {
    StateDto getStateById(Long id);
    State saveState(StateRequest stateRequest);
    State updateState(StateRequest stateRequest);
    List<StateDto> getAll();
    void deleteById(Long id);
}
