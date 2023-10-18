package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.ItemTypeDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.ItemTypeRequest;
import com.example.finalproject.Model.ItemType;
import com.example.finalproject.Repository.ItemTypeRepository;
import com.example.finalproject.mapper.ItemTypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemTypeService implements com.example.finalproject.service.ItemTypeService {
    private final ItemTypeRepository itemTypeRepository;
    private final ItemTypeMapper mapper;
    @Override
    public ItemTypeDto getItemTypeById(Long id) {
        log.info("Fetching item details for ID: {}", id);
        ItemTypeDto result = mapper.toDto(
                itemTypeRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("item not found for ID: {}", id);
                            return new ResourceNotFoundException("item", "id", id);
                        }));
        log.info("Successfully fetched item details for ID: {}", id);
        return result;
    }

    @Override
    public ItemType saveItemType(ItemTypeRequest itemTypeRequest) {
        log.info("Saving new item.");
        ItemType savedItemType = itemTypeRepository.save(mapper.toEntity(itemTypeRequest));
        log.info("Successfully saved new item.");
        return savedItemType;
    }

    @Override
    public ItemType updateItemType(ItemTypeRequest itemTypeRequest) {
        log.info("Updating item with ID: {}", itemTypeRequest.getId());
        if (!itemTypeRepository.existsById(itemTypeRequest.getId())) {
            log.error("item not found for updating. ID: {}", itemTypeRequest.getId());
            throw new ResourceNotFoundException("item", "Id not found", itemTypeRequest.getId());
        }
        ItemType updatedItemType = itemTypeRepository.save(mapper.toEntity(itemTypeRequest));
        log.info("Successfully updated item with ID: {}", updatedItemType.getId());
        return updatedItemType;
    }

    @Override
    public List<ItemTypeDto> getAll() {
        log.info("Fetching all item details.");
        List<ItemType> itemTypes = itemTypeRepository.findAll();
        log.info("Successfully fetched all item details.");
        return mapper.toDto(itemTypes);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting item with ID: {}", id);
        if (!itemTypeRepository.existsById(id)) {
            log.error("item not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("City", "Id not found", id);
        }
        itemTypeRepository.deleteById(id);
        log.info("Successfully deleted item with ID: {}", id);

    }
}
