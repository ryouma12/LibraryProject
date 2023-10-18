package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.PatronDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.PatronRequest;
import com.example.finalproject.Model.Patron;
import com.example.finalproject.Repository.PatronRepository;
import com.example.finalproject.mapper.PatronMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatronService implements com.example.finalproject.service.PatronService {
    private final PatronRepository patronRepository;
    private final PatronMapper mapper;
    @Override
    public PatronDto getPatronById(Long id) {
        log.info("Fetching patron details for ID: {}", id);
        PatronDto result = mapper.toDto(
                patronRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("patron not found for ID: {}", id);
                            return new ResourceNotFoundException("patron", "id", id);
                        }));
        log.info("Successfully fetched patron details for ID: {}", id);
        return result;
    }

    @Override
    public Patron savePatron(PatronRequest patronRequest) {
        log.info("Saving new patron.");
        Patron savedPatron = patronRepository.save(mapper.toEntity(patronRequest));
        log.info("Successfully saved new patron with ID: {}", savedPatron.getId());
        return savedPatron;
    }

    @Override
    public Patron updatePatron(PatronRequest patronRequest) {
        log.info("Updating patron with ID: {}", patronRequest.getId());
        if (!patronRepository.existsById(patronRequest.getId())) {
            log.error("patron not found for updating. ID: {}", patronRequest.getId());
            throw new ResourceNotFoundException("patron", "Id not found", patronRequest.getId());
        }
        Patron updatePatron = patronRepository.save(mapper.toEntity(patronRequest));
        log.info("Successfully updated patron with ID: {}", updatePatron.getId());
        return updatePatron;
    }

    @Override
    public List<PatronDto> getAll() {
        log.info("Fetching all patron details.");
        List<Patron> patrons = patronRepository.findAll();
        log.info("Successfully fetched all patron details.");
        return mapper.toDto(patrons);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting patron with ID: {}", id);
        if (!patronRepository.existsById(id)) {
            log.error("patron not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("patron", "Id not found", id);
        }
        patronRepository.deleteById(id);
        log.info("Successfully deleted patron with ID: {}", id);

    }
}
