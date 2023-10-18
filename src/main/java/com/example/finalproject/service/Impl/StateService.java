package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.StateDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.StateRequest;
import com.example.finalproject.Model.State;
import com.example.finalproject.Repository.StateRepository;
import com.example.finalproject.mapper.StateMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StateService implements com.example.finalproject.service.StateService {
    private final StateRepository stateRepository;
    private final StateMapper mapper;


    @Override
    public StateDto getStateById(Long id) {
        log.info("Fetching state details for ID: {}", id);
        StateDto result = mapper.toDto(
                stateRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("State not found for ID: {}", id);
                            return new ResourceNotFoundException("State", "id", id);
                        }));
        log.info("Successfully fetched state details for ID: {}", id);
        return result;
    }

    @Override
    public List<StateDto> getAll() {
        log.info("Fetching all state details.");
        List<State> states = stateRepository.findAll();
        log.info("Successfully fetched all state details.");
        return mapper.toDto(states);
    }

    @Override
    public State saveState(StateRequest stateRequest) {
        log.info("Saving new state.");
        State savedState = stateRepository.save(mapper.toEntity(stateRequest));
        log.info("Successfully saved new state with ID: {}", savedState.getId());
        return savedState;
    }

    @Override
    public State updateState(StateRequest stateRequest) {
        log.info("Updating state with ID: {}", stateRequest.getId());
        if (!stateRepository.existsById(stateRequest.getId())) {
            log.error("State not found for updating. ID: {}", stateRequest.getId());
            throw new ResourceNotFoundException("State", "Id not found", stateRequest.getId());
        }
        State updatedState = stateRepository.save(mapper.toEntity(stateRequest));
        log.info("Successfully updated state with ID: {}", updatedState.getId());
        return updatedState;
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting state with ID: {}", id);
        if (!stateRepository.existsById(id)) {
            log.error("State not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("State", "Id not found", id);
        }
        stateRepository.deleteById(id);
        log.info("Successfully deleted state with ID: {}", id);
    }
}

