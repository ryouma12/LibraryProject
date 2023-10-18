package com.example.finalproject.Dto.request;

import com.example.finalproject.Model.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;


}
