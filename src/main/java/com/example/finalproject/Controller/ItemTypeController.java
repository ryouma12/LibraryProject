package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ItemTypeDto;
import com.example.finalproject.Dto.request.ItemTypeRequest;
import com.example.finalproject.Model.ItemType;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.ItemTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item_type")
public class ItemTypeController {

    private final ItemTypeService itemTypeService;

    @GetMapping(value = "/itemTypeList")
    public ResponseEntity<BaseResponse<List<ItemTypeDto>>>
    getItemTypeInfo() {
        List<ItemTypeDto> itemTypeDtos = itemTypeService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Types list successfully retrieved", itemTypeDtos));
    }

    @GetMapping(value = "/getItemTypeById/{id}")
    public ResponseEntity<BaseResponse<ItemTypeDto>>
    getItemTypeById(@PathVariable(value = "id") Long id) {
        ItemTypeDto itemTypeDto = itemTypeService.getItemTypeById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Type successfully retrieved", itemTypeDto));
    }

    @PostMapping(value = "/saveItemType")
    public ResponseEntity<BaseResponse<ItemType>>
    saveItemType(@RequestBody ItemTypeRequest itemTypeRequest) {
        ItemType itemType = itemTypeService.saveItemType(itemTypeRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Type successfully saved", itemType));
    }

    @PutMapping(value = "/updateItemType")
    public ResponseEntity<BaseResponse<ItemType>>
    updateItemType(@RequestBody ItemTypeRequest itemTypeRequest) {
        ItemType itemType = itemTypeService.updateItemType(itemTypeRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Item Type successfully updated", itemType));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        itemTypeService.deleteById(id);
        return ResponseEntity.ok("Item Type successfully deleted");
    }
}

