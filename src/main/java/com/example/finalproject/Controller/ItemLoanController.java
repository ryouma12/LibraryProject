package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ItemLoanIDto;
import com.example.finalproject.Dto.request.ItemLoanRequest;
import com.example.finalproject.Model.ItemLoan;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.ItemLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item_loan")
public class ItemLoanController {

    private final ItemLoanService itemLoanService;

    @GetMapping(value = "/itemLoanList")
    public ResponseEntity<BaseResponse<List<ItemLoanIDto>>> getItemLoanInfo() {
        List<ItemLoanIDto> itemLoanDtos = itemLoanService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Loans list successfully retrieved", itemLoanDtos));
    }

    @GetMapping(value = "/getItemLoanById/{id}")
    public ResponseEntity<BaseResponse<ItemLoanIDto>> getItemLoanById(@PathVariable(value = "id") Long id) {
        ItemLoanIDto itemLoanDto = itemLoanService.getItemLoanById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Loan successfully retrieved", itemLoanDto));
    }

    @PostMapping(value = "/saveItemLoan")
    public ResponseEntity<BaseResponse<ItemLoan>> saveItemLoan(@RequestBody ItemLoanRequest itemLoanRequest) {
        ItemLoan itemLoan = itemLoanService.saveItemLoan(itemLoanRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Loan successfully saved", itemLoan));
    }

    @PutMapping(value = "/updateItemLoan")
    public ResponseEntity<BaseResponse<ItemLoan>> updateItemLoan(@RequestBody ItemLoanRequest itemLoanRequest) {
        ItemLoan itemLoan = itemLoanService.updateItemLoan(itemLoanRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Loan successfully updated", itemLoan));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "id") Long id) {
        itemLoanService.deleteById(id);
        return ResponseEntity.ok("Item Loan successfully deleted");
    }
}
