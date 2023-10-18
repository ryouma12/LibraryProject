package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.LibrarianDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.LibrarianRequest;
import com.example.finalproject.Model.Librarian;
import com.example.finalproject.Repository.LibrarianRepository;
import com.example.finalproject.mapper.LibrarianMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LibrarianService implements com.example.finalproject.service.LibrarianService {
    private final LibrarianRepository librarianRepository;
    private final LibrarianMapper mapper;
    @Override
    public LibrarianDto getLibrarianById(Long id) {
        log.info("Fetching librarian details for ID: {}", id);
        LibrarianDto result = mapper.toDto(
                librarianRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("librarian not found for ID: {}", id);
                            return new ResourceNotFoundException("Faculty", "id", id);
                        }));
        log.info("Successfully fetched librariran details for ID: {}", id);
        return result;
    }

    @Override
    public Librarian saveLibrarian(LibrarianRequest librarianRequest) {
        log.info("Saving new librarian.");
        Librarian savedLibrarian = librarianRepository.save(mapper.toEntity(librarianRequest));
        log.info("Successfully saved new librarian with ID: {}", savedLibrarian.getId());
        return savedLibrarian;
    }

    @Override
    public Librarian updateLibrarian(LibrarianRequest librarianRequest) {
        log.info("Updating librarian with ID: {}", librarianRequest.getId());
        if (!librarianRepository.existsById(librarianRequest.getId())) {
            log.error("librarian not found for updating. ID: {}", librarianRequest.getId());
            throw new ResourceNotFoundException("librarian", "Id not found", librarianRequest.getId());
        }
        Librarian updatedLibrarian = librarianRepository.save(mapper.toEntity(librarianRequest));
        log.info("Successfully updated librarian with ID: {}", updatedLibrarian.getId());
        return updatedLibrarian;
    }

    @Override
    public List<LibrarianDto> getAll() {
        log.info("Fetching all librarian details.");
        List<Librarian> librarians = librarianRepository.findAll();
        log.info("Successfully fetched all librarian details.");
        return mapper.toDto(librarians);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting librarian with ID: {}", id);
        if (!librarianRepository.existsById(id)) {
            log.error("librarian not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("librarian", "Id not found", id);
        }
        librarianRepository.deleteById(id);
        log.info("Successfully deleted librarian with ID: {}", id);

    }
}
