package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.PublisherDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.PublisherRequest;
import com.example.finalproject.Model.Publisher;
import com.example.finalproject.Repository.PublisherRepository;
import com.example.finalproject.mapper.PublisherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublisherService implements com.example.finalproject.service.PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper mapper;
    @Override
    public PublisherDto getPublisherById(Long id) {
        log.info("Fetching publisher details for ID: {}", id);
        PublisherDto result = mapper.toDto(
                publisherRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("publisher not found for ID: {}", id);
                            return new ResourceNotFoundException("publisher", "id", id);
                        }));
        log.info("Successfully fetched publisher details for ID: {}", id);
        return result;
    }

    @Override
    public Publisher savePublisher(PublisherRequest publisherRequest) {
        log.info("Saving new publisher.");
        Publisher savedPublisher= publisherRepository.save(mapper.toEntity(publisherRequest));
        log.info("Successfully saved new publisher with ID: {}", savedPublisher.getId());
        return savedPublisher;
    }

    @Override
    public Publisher updatePublisher(PublisherRequest publisherRequest) {
        log.info("Updating publisher with ID: {}", publisherRequest.getId());
        if (!publisherRepository.existsById(publisherRequest.getId())) {
            log.error("publisher not found for updating. ID: {}", publisherRequest.getId());
            throw new ResourceNotFoundException("publisher", "Id not found", publisherRequest.getId());
        }
        Publisher updatedPublisher = publisherRepository.save(mapper.toEntity(publisherRequest));
        log.info("Successfully updated publisher with ID: {}", updatedPublisher.getId());
        return updatedPublisher;
    }

    @Override
    public List<PublisherDto> getAll() {
        log.info("Fetching all publisher details.");
        List<Publisher> publishers = publisherRepository.findAll();
        log.info("Successfully fetched all publisher details.");
        return mapper.toDto(publishers);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting publisher with ID: {}", id);
        if (!publisherRepository.existsById(id)) {
            log.error("publisher not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("publisher", "Id not found", id);
        }
        publisherRepository.deleteById(id);
        log.info("Successfully deleted publisher with ID: {}", id);

    }
}
