package com.example.finalproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BranchDto {
    private String name;
    private String street;
    private String city;
    private String zip;
    private String phone;
    private String fax;
}
