package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.BranchDto;
import com.example.finalproject.Dto.CopyStatDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.CopyStatRequest;
import com.example.finalproject.Model.CopyStat;
import com.example.finalproject.Repository.CopyStatRepository;
import com.example.finalproject.mapper.CopyStatMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CopyStatService implements com.example.finalproject.service.CopyStatService {
    private final CopyStatRepository copyStatRepository;
    private final CopyStatMapper mapper;

    @Override
    public CopyStatDto getCopyStatById(Long id) {
        log.info("Fetching copystat details for ID: {}", id);
        CopyStatDto result = mapper.toDto(
                copyStatRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("Copystat not found for ID: {}", id);
                            return new ResourceNotFoundException("Copystat", "id", id);
                        }));
        log.info("Successfully fetched copystat details for ID: {}", id);
        return result;
    }

    @Override
    public CopyStat saveCopyStat(CopyStatRequest copyStatRequest) {
        log.info("Saving new copystat.");
        CopyStat savedCopyStat = copyStatRepository.save(mapper.toEntity(copyStatRequest));
        log.info("Successfully saved new copystat.");
        return savedCopyStat;
    }

    @Override
    public CopyStat updateCopyStat(CopyStatRequest copyStatRequest) {

        log.info("Updating copystat with ID: {}", copyStatRequest.getId());
        if (!copyStatRepository.existsById(copyStatRequest.getId())) {
            log.error("Copystat not found for updating. ID: {}", copyStatRequest.getId());
            throw new ResourceNotFoundException("copystat", "Id not found", copyStatRequest.getId());
        }
        CopyStat updatedCopyStat = copyStatRepository.save(mapper.toEntity(copyStatRequest));

        log.info("Successfully updated copystat position with ID: {}", updatedCopyStat.getId());
        return updatedCopyStat;

    }

    @Override
    public List<CopyStatDto> getAll() {
        log.info("Fetching all copystat details.");
        List<CopyStat> copyStats = copyStatRepository.findAll();
        log.info("Successfully fetched all copystat details.");
        return mapper.toDto(copyStats);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting copystat with ID: {}", id);
        if (!copyStatRepository.existsById(id)) {
            log.error("Copystat not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("Copystat", "Id not found", id);
        }
        copyStatRepository.deleteById(id);
        log.info("Successfully deleted copystat with ID: {}", id);

    }
}
