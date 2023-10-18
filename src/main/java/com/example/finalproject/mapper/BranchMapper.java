package com.example.finalproject.mapper;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.BranchDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.BranchRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.Branch;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    Branch toEntity(BranchRequest branchRequest);
    BranchDto toDto(Branch branch);
    Branch toEntity(BranchDto branchDto);
    List<BranchDto> toDto(List<Branch> branches);
    List<Branch> toEntity(List<BranchDto> branchDtos);
}
