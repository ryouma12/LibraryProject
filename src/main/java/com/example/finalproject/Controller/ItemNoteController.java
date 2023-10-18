package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ItemNoteDto;
import com.example.finalproject.Dto.request.ItemNoteRequest;
import com.example.finalproject.Model.ItemNote;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.ItemNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/itemnote")
public class ItemNoteController {

    private final ItemNoteService itemNoteService;

    @GetMapping(value = "/itemNoteList")
    public ResponseEntity<BaseResponse<List<ItemNoteDto>>>
    getItemNoteInfo() {
        List<ItemNoteDto> itemNoteDtos = itemNoteService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Notes list successfully retrieved", itemNoteDtos));
    }

    @GetMapping(value = "/getItemNoteById/{id}")
    public ResponseEntity<BaseResponse<ItemNoteDto>>
    getItemNoteById(@PathVariable(value = "id") Long id) {
        ItemNoteDto itemNoteDto = itemNoteService.getItemNoteById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Note successfully retrieved", itemNoteDto));
    }

    @PostMapping(value = "/saveItemNote")
    public ResponseEntity<BaseResponse<ItemNote>>
    saveItemNote(@RequestBody ItemNoteRequest itemNoteRequest) {
        ItemNote itemNote = itemNoteService.saveItemNote(itemNoteRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Note successfully saved", itemNote));
    }

    @PutMapping(value = "/updateItemNote")
    public ResponseEntity<BaseResponse<ItemNote>>
    updateItemNote(@RequestBody ItemNoteRequest itemNoteRequest) {
        ItemNote itemNote = itemNoteService.updateItemNote(itemNoteRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Note successfully updated", itemNote));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        itemNoteService.deleteById(id);
        return ResponseEntity.ok("Item Note successfully deleted");
    }
}

