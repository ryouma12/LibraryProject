package com.example.finalproject.Dto;

import com.example.finalproject.Model.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemNoteDto {
    private String body;
    private Item item;
}
