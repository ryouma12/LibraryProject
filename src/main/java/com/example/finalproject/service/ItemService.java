package com.example.finalproject.service;

import com.example.finalproject.Dto.ItemDto;
import com.example.finalproject.Dto.ItemNoteDto;
import com.example.finalproject.Dto.request.ItemNoteRequest;
import com.example.finalproject.Dto.request.ItemRequest;
import com.example.finalproject.Model.Item;
import com.example.finalproject.Model.ItemNote;

import java.util.List;

public interface ItemService {
    ItemDto getItemById(Long id);
    Item saveItem(ItemRequest itemRequest);
    Item updateItem(ItemRequest itemRequest);
    List<ItemDto> getAll();
    void deleteById(Long id);
}
