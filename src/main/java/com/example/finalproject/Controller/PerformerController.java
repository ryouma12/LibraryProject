package com.example.finalproject.Controller;

import com.example.finalproject.Dto.PerformerDto;
import com.example.finalproject.Dto.request.PerformerRequest;
import com.example.finalproject.Model.Performer;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.PerformerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/performer")
public class PerformerController {

    private final PerformerService performerService;

    @GetMapping(value = "/performerList")
    public ResponseEntity<BaseResponse<List<PerformerDto>>>
    getPerformerInfo() {
        List<PerformerDto> performerDtos = performerService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Performer list successfully retrieved", performerDtos));
    }

    @GetMapping(value = "/getPerformerById/{id}")
    public ResponseEntity<BaseResponse<PerformerDto>>
    getPerformerById(@PathVariable(value = "id") Long id) {
        PerformerDto performerDto = performerService.getPerformerById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Performer successfully retrieved", performerDto));
    }

    @PostMapping(value = "/savePerformer")
    public ResponseEntity<BaseResponse<Performer>>
    savePerformer(@RequestBody PerformerRequest performerRequest) {
        Performer performer = performerService.savePerformer(performerRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Performer successfully saved", performer));
    }

    @PutMapping(value = "/updatePerformer")
    public ResponseEntity<BaseResponse<Performer>>
    updatePerformer(@RequestBody PerformerRequest performerRequest) {
        Performer performer = performerService.updatePerformer(performerRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Performer successfully updated", performer));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        performerService.deleteById(id);
        return ResponseEntity.ok("Performer successfully deleted");
    }
}

