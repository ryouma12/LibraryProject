package com.example.finalproject.Controller;

import com.example.finalproject.Dto.CopyStatDto;
import com.example.finalproject.Dto.request.CopyStatRequest;
import com.example.finalproject.Model.CopyStat;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.CopyStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/copyStat")
public class CopyStatController {

    private final CopyStatService copyStatService;

    @GetMapping(value = "/copyStatList")
    public ResponseEntity<BaseResponse<List<CopyStatDto>>>
    getCopyStatInfo() {
        List<CopyStatDto> copyStatDtos = copyStatService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "CopyStat list successfully retrieved", copyStatDtos));
    }

    @GetMapping(value = "/getCopyStatById/{id}")
    public ResponseEntity<BaseResponse<CopyStatDto>>
    getCopyStatById(@PathVariable(value = "id") Long id) {
        CopyStatDto copyStatDto = copyStatService.getCopyStatById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "CopyStat successfully retrieved", copyStatDto));
    }

    @PostMapping(value = "/saveCopyStat")
    public ResponseEntity<BaseResponse<CopyStat>>
    saveCopyStat(@RequestBody CopyStatRequest copyStatRequest) {
        CopyStat copyStat = copyStatService.saveCopyStat(copyStatRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "CopyStat successfully saved", copyStat));
    }

    @PutMapping(value = "/updateCopyStat")
    public ResponseEntity<BaseResponse<CopyStat>>
    updateCopyStat(@RequestBody CopyStatRequest copyStatRequest) {
        CopyStat copyStat = copyStatService.updateCopyStat(copyStatRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "CopyStat successfully updated", copyStat));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        copyStatService.deleteById(id);
        return ResponseEntity.ok("CopyStat successfully deleted");
    }
}

