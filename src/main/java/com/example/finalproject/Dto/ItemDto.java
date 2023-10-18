package com.example.finalproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private String title;
    private String description;
    private String borrowable;
    private String publishYear;
    private Integer callNumber;
}
