package com.example.finalproject.Controller;

import com.example.finalproject.Dto.StateDto;
import com.example.finalproject.Dto.request.StateRequest;
import com.example.finalproject.Model.State;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.StateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/state")
public class StateController {

    private final StateService stateService;

    @GetMapping(value = "/stateList")
    public ResponseEntity<BaseResponse<List<StateDto>>>
    getStateInfo() {
        List<StateDto> stateDtos = stateService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "State list successfully retrieved", stateDtos));
    }

    @GetMapping(value = "/getStateById/{id}")
    public ResponseEntity<BaseResponse<StateDto>>
    getStateById(@PathVariable(value = "id") Long id) {
        StateDto stateDto = stateService.getStateById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "State successfully retrieved", stateDto));
    }

    @PostMapping(value = "/saveState")
    public ResponseEntity<BaseResponse<State>>
    saveState(@RequestBody StateRequest stateRequest) {
        State state = stateService.saveState(stateRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "State successfully saved", state));
    }

    @PutMapping(value = "/updateState")
    public ResponseEntity<BaseResponse<State>>
    updateState(@RequestBody StateRequest stateRequest) {
        State state = stateService.updateState(stateRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "State successfully updated", state));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        stateService.deleteById(id);
        return ResponseEntity.ok("State successfully deleted");
    }
}

