package com.example.finalproject.service;

import com.example.finalproject.Dto.BranchDto;
import com.example.finalproject.Dto.request.BranchRequest;
import com.example.finalproject.Model.Branch;

import java.util.List;

public interface BranchService {
    BranchDto getBranchById(Long id);
    Branch saveBranch(BranchRequest branchRequest);
    Branch updateBranch(BranchRequest branchRequest);
    List<BranchDto> getAll();
    void deleteById(Long id);
}
