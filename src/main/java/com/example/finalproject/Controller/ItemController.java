package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ItemDto;
import com.example.finalproject.Dto.request.ItemRequest;
import com.example.finalproject.Model.Item;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping(value = "/itemList")
    public ResponseEntity<BaseResponse<List<ItemDto>>>
    getItemInfo() {
        List<ItemDto> itemDtos = itemService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item list successfully retrieved", itemDtos));
    }

    @GetMapping(value = "/getItemById/{id}")
    public ResponseEntity<BaseResponse<ItemDto>>
    getItemById(@PathVariable(value = "id") Long id) {
        ItemDto itemDto = itemService.getItemById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item successfully retrieved", itemDto));
    }

    @PostMapping(value = "/saveItem")
    public ResponseEntity<BaseResponse<Item>>
    saveItem(@RequestBody ItemRequest itemRequest) {
        Item item = itemService.saveItem(itemRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item successfully saved", item));
    }

    @PutMapping(value = "/updateItem")
    public ResponseEntity<BaseResponse<Item>>
    updateItem(@RequestBody ItemRequest itemRequest) {
        Item item = itemService.updateItem(itemRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item successfully updated", item));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        itemService.deleteById(id);
        return ResponseEntity.ok("Item successfully deleted");
    }
}

