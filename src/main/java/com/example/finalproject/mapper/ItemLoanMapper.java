package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.ItemLoanIDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.ItemLoanRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.ItemLoan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemLoanMapper{
    ItemLoan toEntity(ItemLoanRequest itemLoanRequest);
    ItemLoanIDto toDto(ItemLoan itemLoan);
    ItemLoan toEntity(ItemLoanIDto itemLoanIDto);
    List<ItemLoanIDto> toDto(List<ItemLoan> itemLoans);
    List<ItemLoan> toEntity(List<ItemLoanIDto> itemLoanIDtos);

}
