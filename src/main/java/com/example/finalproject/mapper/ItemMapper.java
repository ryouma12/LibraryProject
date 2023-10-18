package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.ItemDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.ItemLoanRequest;
import com.example.finalproject.Dto.request.ItemRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toEntity(ItemRequest itemRequest);
    ItemDto toDto(Item item);
    Item toEntity(ItemDto itemDto);
    List<ItemDto> toDto(List<Item> items);
    List<Item> toEntity(List<ItemDto> itemDtos);
}
