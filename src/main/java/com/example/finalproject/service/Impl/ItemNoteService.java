package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.ItemNoteDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.ItemNoteRequest;
import com.example.finalproject.Model.ItemNote;
import com.example.finalproject.Repository.ItemNoteRepository;
import com.example.finalproject.mapper.ItemNotemapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemNoteService implements com.example.finalproject.service.ItemNoteService {
    private final ItemNoteRepository itemNoteRepository;
    private final ItemNotemapper mapper;
    @Override
    public ItemNoteDto getItemNoteById(Long id) {
        log.info("Fetching itemnote details for ID: {}", id);
        ItemNoteDto result = mapper.toDto(
                itemNoteRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("itemnote not found for ID: {}", id);
                            return new ResourceNotFoundException("itemnote", "id", id);
                        }));
        log.info("Successfully fetched itemnote details for ID: {}", id);
        return result;
    }

    @Override
    public ItemNote saveItemNote(ItemNoteRequest itemNoteRequest) {
        log.info("Saving new itemnote.");
        ItemNote savedItemNote = itemNoteRepository.save(mapper.toEntity(itemNoteRequest));
        log.info("Successfully saved new itemnote.");
        return savedItemNote;
    }

    @Override
    public ItemNote updateItemNote(ItemNoteRequest itemNoteRequest) {
        log.info("Updating itemnote with ID: {}", itemNoteRequest.getId());
        if (!itemNoteRepository.existsById(itemNoteRequest.getId())) {
            log.error("itemnote not found for updating. ID: {}", itemNoteRequest.getId());
            throw new ResourceNotFoundException("itemnote", "Id not found", itemNoteRequest.getId());
        }
        ItemNote updatedItemnote = itemNoteRepository.save(mapper.toEntity(itemNoteRequest));
        log.info("Successfully updated itemnote with ID: {}", updatedItemnote.getId());
        return updatedItemnote;
    }

    @Override
    public List<ItemNoteDto> getAll() {
        log.info("Fetching all itemnote details.");
        List<ItemNote> itemNotes = itemNoteRepository.findAll();
        log.info("Successfully fetched all itemnote details.");
        return mapper.toDto(itemNotes);
    }

    @Override
    public void deleteById(Long id) {

        log.info("Deleting itemnote with ID: {}", id);
        if (!itemNoteRepository.existsById(id)) {
            log.error("Itemnote not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Itemnote", "Id not found", id);
        }
        itemNoteRepository.deleteById(id);
        log.info("Successfully deleted itemnote with ID: {}", id);

    }
}
