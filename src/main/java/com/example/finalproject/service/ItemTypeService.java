package com.example.finalproject.service;

import com.example.finalproject.Dto.ItemNoteDto;
import com.example.finalproject.Dto.ItemTypeDto;
import com.example.finalproject.Dto.request.ItemNoteRequest;
import com.example.finalproject.Dto.request.ItemTypeRequest;
import com.example.finalproject.Model.ItemNote;
import com.example.finalproject.Model.ItemType;

import java.util.List;

public interface ItemTypeService {
    ItemTypeDto getItemTypeById(Long id);
    ItemType saveItemType(ItemTypeRequest itemTypeRequest);
    ItemType updateItemType(ItemTypeRequest itemTypeRequest);
    List<ItemTypeDto> getAll();
    void deleteById(Long id);
}
