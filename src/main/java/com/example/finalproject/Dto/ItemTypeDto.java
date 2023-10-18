package com.example.finalproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemTypeDto {
    private String name;
    private String abbreviation;
    private Integer perDay;
    private Integer maxFine;
}
