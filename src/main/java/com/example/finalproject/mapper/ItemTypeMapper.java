package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.ItemDto;
import com.example.finalproject.Dto.ItemTypeDto;
import com.example.finalproject.Dto.request.ItemTypeRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.ItemType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemTypeMapper {
    ItemType toEntity(ItemTypeRequest itemTypeRequest);
    ItemTypeDto toDto(ItemType itemType);
    ItemType toEntity(ItemDto itemDto);
    List<ItemTypeDto> toDto(List<ItemType> itemTypes);
    List<ItemType> toEntity(List<ItemTypeDto> itemTypeDtos);
}
