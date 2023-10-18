package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.SubjectDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.SubjectRequest;
import com.example.finalproject.Model.Subject;
import com.example.finalproject.Repository.SubjectRepository;
import com.example.finalproject.mapper.SubjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor

public class SubjectService implements com.example.finalproject.service.SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper mapper;

    @Override
    public SubjectDto getSubjectById(Long id) {
        log.info("Fetching subject details for ID: {}", id);
        SubjectDto result = mapper.toDto(
                subjectRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Subject not found for ID: {}", id);
                            return new ResourceNotFoundException("Subject", "id", id);
                        }));
        log.info("Successfully fetched subject details for ID: {}", id);
        return result;
    }


    @Override
    public List<SubjectDto> getAll() {
        log.info("Fetching all subject details.");
        List<Subject> subjects = subjectRepository.findAll();
        log.info("Successfully fetched all subject details.");
        return mapper.toDto(subjects);
    }

    @Override
    public Subject saveSubject(SubjectRequest subjectRequest) {
        log.info("Saving new subject.");
        Subject savedSubject = subjectRepository.save(mapper.toEntity(subjectRequest));
        log.info("Successfully saved new subject with ID: {}", savedSubject.getId());
        return savedSubject;
    }

    @Override

    public Subject updateSubject(SubjectRequest subjectRequest) {
        log.info("Updating subject with ID: {}", subjectRequest.getId());
        if (!subjectRepository.existsById(subjectRequest.getId())) {
            log.error("Subject not found for updating. ID: {}", subjectRequest.getId());
            throw new ResourceNotFoundException("Subject", "Id not found", subjectRequest.getId());
        }
        Subject updatedSubject = subjectRepository.save(mapper.toEntity(subjectRequest));
        log.info("Successfully updated subject with ID: {}", updatedSubject.getId());
        return updatedSubject;
    }

    @Override

    public void deleteById(Long id) {
        log.info("Deleting subject with ID: {}", id);
        if (!subjectRepository.existsById(id)) {
            log.error("Subject not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Subject", "Id not found", id);
        }
        subjectRepository.deleteById(id);
        log.info("Successfully deleted subject with ID: {}", id);
    }
}
