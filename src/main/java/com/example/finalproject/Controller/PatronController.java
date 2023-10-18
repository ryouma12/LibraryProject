package com.example.finalproject.Controller;

import com.example.finalproject.Dto.PatronDto;
import com.example.finalproject.Dto.request.PatronRequest;
import com.example.finalproject.Model.Patron;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.PatronService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/patron")
public class PatronController {

    private final PatronService patronService;

    @GetMapping(value = "/patronList")
    public ResponseEntity<BaseResponse<List<PatronDto>>>
    getPatronInfo() {
        List<PatronDto> patronDtos = patronService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Patron list successfully retrieved", patronDtos));
    }

    @GetMapping(value = "/getPatronById/{id}")
    public ResponseEntity<BaseResponse<PatronDto>>
    getPatronById(@PathVariable(value = "id") Long id) {
        PatronDto patronDto = patronService.getPatronById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Patron successfully retrieved", patronDto));
    }

    @PostMapping(value = "/savePatron")
    public ResponseEntity<BaseResponse<Patron>>
    savePatron(@RequestBody PatronRequest patronRequest) {
        Patron patron = patronService.savePatron(patronRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Patron successfully saved", patron));
    }

    @PutMapping(value = "/updatePatron")
    public ResponseEntity<BaseResponse<Patron>>
    updatePatron(@RequestBody PatronRequest patronRequest) {
        Patron patron = patronService.updatePatron(patronRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Patron successfully updated", patron));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        patronService.deleteById(id);
        return ResponseEntity.ok("Patron successfully deleted");
    }
}

