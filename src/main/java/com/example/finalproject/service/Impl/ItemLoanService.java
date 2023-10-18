package com.example.finalproject.service.Impl;

import com.example.finalproject.Dto.ItemLoanIDto;
import com.example.finalproject.Dto.exception.ResourceNotFoundException;
import com.example.finalproject.Dto.request.ItemLoanRequest;
import com.example.finalproject.Model.ItemLoan;
import com.example.finalproject.Repository.ItemLoanRepository;
import com.example.finalproject.mapper.ItemLoanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemLoanService implements com.example.finalproject.service.ItemLoanService {
    private final ItemLoanRepository itemLoanRepository;
    private final ItemLoanMapper mapper;
    @Override
    public ItemLoanIDto getItemLoanById(Long id) {
        log.info("Fetching itemloan details for ID: {}", id);
        ItemLoanIDto result = mapper.toDto(
                itemLoanRepository.findById(id)
                        .orElseThrow(() -> {
                            log.error("itemloan not found for ID: {}", id);
                            return new ResourceNotFoundException("itemloan", "id", id);
                        }));
        log.info("Successfully fetched itemloan details for ID: {}", id);
        return result;
    }

    @Override
    public ItemLoan saveItemLoan(ItemLoanRequest itemLoanRequest) {
        log.info("Saving new itemloan.");
        ItemLoan savedItemLoan = itemLoanRepository.save(mapper.toEntity(itemLoanRequest));
        log.info("Successfully saved new itemloan.");
        return savedItemLoan;
    }

    @Override
    public ItemLoan updateItemLoan(ItemLoanRequest itemLoanRequest) {
        log.info("Updating itemloan with ID: {}", itemLoanRequest.getId());
        if (!itemLoanRepository.existsById(itemLoanRequest.getId())) {
            log.error("itemloan not found for updating. ID: {}", itemLoanRequest.getId());
            throw new ResourceNotFoundException("itemloan", "Id not found", itemLoanRequest.getId());
        }
        ItemLoan updatedItemLoan = itemLoanRepository.save(mapper.toEntity(itemLoanRequest));

        log.info("Successfully updated itemloan with ID: {}", updatedItemLoan.getId());
        return updatedItemLoan;
    }

    @Override
    public List<ItemLoanIDto> getAll() {
        log.info("Fetching all itemloan details.");
        List<ItemLoan> itemLoans = itemLoanRepository.findAll();
        log.info("Successfully fetched all itemloan details.");
        return mapper.toDto(itemLoans);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting itemloan with ID: {}", id);
        if (!itemLoanRepository.existsById(id)) {
            log.error("itemloan not found for deletion. ID: {}", id);
            throw new ResourceNotFoundException("itemloan", "Id not found", id);
        }
        itemLoanRepository.deleteById(id);
        log.info("Successfully deleted itemloan with ID: {}", id);

    }
}
