package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.BranchDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.BranchRequest;
import com.example.finalproject.Model.Branch;
import com.example.finalproject.Repository.BranchRepository;
import com.example.finalproject.mapper.BranchMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BranchService implements com.example.finalproject.service.BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper mapper;

    @Override
    public BranchDto getBranchById(Long id) {

        log.info("Fetching branch details for ID: {}", id);
        BranchDto result = mapper.toDto(
                branchRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Branch not found for ID: {}", id);
                            return new ResourceNotFoundException("Branch", "id", id);
                        }));
        log.info("Successfully fetched  branch details for ID: {}", id);
        return result;
    }

    @Override
    public Branch saveBranch(BranchRequest branchRequest) {
        log.info("Saving branch position.");
        Branch savedBranch = branchRepository.save(mapper.toEntity(branchRequest));
        log.info("Successfully saved new branch.");
        return savedBranch;
    }

    @Override
    public Branch updateBranch(BranchRequest branchRequest) {
        log.info("Updating branch with ID: {}", branchRequest.getId());
        if (!branchRepository.existsById(branchRequest.getId())) {
            log.error("Branch not found for updating. ID: {}", branchRequest.getId());
            throw new ResourceNotFoundException("Branch", "Id not found", branchRequest.getId());
        }
        Branch updatedBranch = branchRepository.save(mapper.toEntity(branchRequest));

        log.info("Successfully updated branch with ID: {}",updatedBranch.getId());
        return updatedBranch;
    }

    @Override
    public List<BranchDto> getAll() {
        log.info("Fetching all branch details.");
        List<Branch> branches = branchRepository.findAll();
        log.info("Successfully fetched all branch details.");
        return mapper.toDto(branches);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting branch with ID: {}", id);
        if (!branchRepository.existsById(id)) {
            log.error("Branch not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Branch", "Id not found", id);
        }
        branchRepository.deleteById(id);
        log.info("Successfully deleted branch with ID: {}", id);

    }
}
