package com.example.finalproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemLoanIDto {
    private String dateIssued;
    private String renewed;
    private String due;
    private String returned;
    private String paymentDate;

}
