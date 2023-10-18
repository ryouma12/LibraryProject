package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Repository.AuthorRepository;
import com.example.finalproject.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorService implements com.example.finalproject.service.AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper mapper;
    @Override
    public AuthorDto getAuthorById(Long id) {
        log.info("Fetching author details for ID: {}", id);
        AuthorDto result = mapper.toDto(
                authorRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Author not found for ID: {}", id);
                            return new ResourceNotFoundException("Author", "id", id);
                        }));
        log.info("Successfully fetched author details for ID: {}", id);
        return result;
    }

    @Override
    public Author saveAuthor(AuthorRequest authorRequest) {
        log.info("Saving new  author.");
        Author savedAuthor = authorRepository.save(mapper.toEntity(authorRequest));
        log.info("Successfully saved new acad position.");
        return savedAuthor;

    }

    @Override
    public Author updateAuthor(AuthorRequest authorRequest) {
        log.info("Updating author with ID: {}", authorRequest.getId());
        if (!authorRepository.existsById(authorRequest.getId())) {
            log.error("Author not found for updating. ID: {}", authorRequest.getId());
            throw new ResourceNotFoundException("Author", "Id not found", authorRequest.getId());
        }
        Author updatedAuthor = authorRepository.save(mapper.toEntity(authorRequest));

        log.info("Successfully updated author with ID: {}", updatedAuthor.getId());
        return updatedAuthor;
    }

    @Override
    public List<AuthorDto> getAll() {
        log.info("Fetching all author details.");
        List<Author> authors = authorRepository.findAll();
        log.info("Successfully fetched all author details.");
        return mapper.toDto(authors);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting author with ID: {}", id);
        if (!authorRepository.existsById(id)) {
            log.error("Author not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Author", "Id not found", id);
        }
        authorRepository.deleteById(id);
        log.info("Successfully deleted author with ID: {}", id);

    }
}
