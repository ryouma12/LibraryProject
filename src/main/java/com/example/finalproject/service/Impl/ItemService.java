package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.ItemDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.ItemRequest;
import com.example.finalproject.Model.Item;
import com.example.finalproject.Repository.ItemRepository;
import com.example.finalproject.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService implements com.example.finalproject.service.ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper mapper;
    @Override
    public ItemDto getItemById(Long id) {
        log.info("Fetching item details for ID: {}", id);
        ItemDto result = mapper.toDto(
                itemRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("item not found for ID: {}", id);
                            return new ResourceNotFoundException("item", "id", id);
                        }));
        log.info("Successfully fetched item details for ID: {}", id);
        return result;
    }

    @Override
    public Item saveItem(ItemRequest itemRequest) {
        log.info("Saving new item.");
        Item savedItem = itemRepository.save(mapper.toEntity(itemRequest));
        log.info("Successfully saved new city.");
        return savedItem;
    }

    @Override
    public Item updateItem(ItemRequest itemRequest) {
        log.info("Updating item with ID: {}", itemRequest.getId());
        if (!itemRepository.existsById(itemRequest.getId())) {
            log.error("item not found for updating. ID: {}", itemRequest.getId());
            throw new ResourceNotFoundException("item", "Id not found", itemRequest.getId());
        }
        Item updatedItem = itemRepository.save(mapper.toEntity(itemRequest));
        log.info("Successfully updated item with ID: {}", updatedItem.getId());
        return updatedItem;
    }

    @Override
    public List<ItemDto> getAll() {
        log.info("Fetching all item details.");
        List<Item> items = itemRepository.findAll();
        log.info("Successfully fetched all item details.");
        return mapper.toDto(items);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting item with ID: {}", id);
        if (!itemRepository.existsById(id)) {
            log.error("item not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("item", "Id not found", id);
        }
        itemRepository.deleteById(id);
        log.info("Successfully deleted item with ID: {}", id);

    }
}
