package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.ItemNoteDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.ItemNoteRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.ItemNote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemNotemapper {
    ItemNote toEntity(ItemNoteRequest itemNoteRequest);
    ItemNoteDto toDto(ItemNote itemNote);
    ItemNote toEntity(ItemNoteDto itemNoteDto);
    List<ItemNoteDto> toDto(List<ItemNote> itemNotes);
    List<ItemNote> toEntity(List<ItemNoteDto> itemNoteDtos);
}
