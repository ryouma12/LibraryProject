package com.example.finalproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatronDto {
    private String phone;
    private String street;
    private String city;
    private String zip;
    private String firstName;
    private String lastName;
    private String email;
    private String middleName;
}
