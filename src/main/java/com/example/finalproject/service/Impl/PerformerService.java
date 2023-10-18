package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.PerformerDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.PerformerRequest;
import com.example.finalproject.Model.Performer;
import com.example.finalproject.Repository.PerformerRepository;
import com.example.finalproject.mapper.PerformerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PerformerService implements com.example.finalproject.service.PerformerService {
    private final PerformerRepository performerRepository;
    private final PerformerMapper mapper;
    @Override
    public PerformerDto getPerformerById(Long id) {
        log.info("Fetching performer details for ID: {}", id);

        PerformerDto result = mapper.toDto(
                performerRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("performer not found for ID: {}", id);
                            return new ResourceNotFoundException("performer", "id", id);
                        }));
        log.info("Successfully fetched performer details for ID: {}", id);
        return result;
    }

    @Override
    public Performer savePerformer(PerformerRequest performerRequest) {
        log.info("Saving new performer.");
        Performer savedPerformer = performerRepository.save(mapper.toEntity(performerRequest));
        log.info("Successfully saved new performer with ID: {}", savedPerformer.getId());
        return savedPerformer;
    }

    @Override
    public Performer updatePerformer(PerformerRequest performerRequest) {
        log.info("Updating performer with ID: {}", performerRequest.getId());
        if (!performerRepository.existsById(performerRequest.getId())) {
            log.error("performer not found for updating. ID: {}", performerRequest.getId());
            throw new ResourceNotFoundException("perfromer", "Id not found", performerRequest.getId());
        }
        Performer updatedPerfromer = performerRepository.save(mapper.toEntity(performerRequest));
        log.info("Successfully updated performer with ID: {}", updatedPerfromer.getId());
        return updatedPerfromer;
    }

    @Override
    public List<PerformerDto> getAll() {
        log.info("Fetching all performer details.");
        List<Performer> performers = performerRepository.findAll();
        log.info("Successfully fetched all performer details.");
        return mapper.toDto(performers);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting performer with ID: {}", id);
        if (!performerRepository.existsById(id)) {
            log.error("performer not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("performer", "Id not found", id);
        }
        performerRepository.deleteById(id);
        log.info("Successfully deleted performer with ID: {}", id);

    }
}
