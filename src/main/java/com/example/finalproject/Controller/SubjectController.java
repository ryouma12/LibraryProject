package com.example.finalproject.Controller;

import com.example.finalproject.Dto.SubjectDto;
import com.example.finalproject.Dto.request.SubjectRequest;
import com.example.finalproject.Model.Subject;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping(value = "/subjectList")
    public ResponseEntity<BaseResponse<List<SubjectDto>>>
    getSubjectInfo() {
        List<SubjectDto> subjectDtos = subjectService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Subject list successfully retrieved", subjectDtos));
    }

    @GetMapping(value = "/getSubjectById/{id}")
    public ResponseEntity<BaseResponse<SubjectDto>>
    getSubjectById(@PathVariable(value = "id") Long id) {
        SubjectDto subjectDto = subjectService.getSubjectById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Subject successfully retrieved", subjectDto));
    }

    @PostMapping(value = "/saveSubject")
    public ResponseEntity<BaseResponse<Subject>>
    saveSubject(@RequestBody SubjectRequest subjectRequest) {
        Subject subject = subjectService.saveSubject(subjectRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Subject successfully saved", subject));
    }

    @PutMapping(value = "/updateSubject")
    public ResponseEntity<BaseResponse<Subject>>
    updateSubject(@RequestBody SubjectRequest subjectRequest) {
        Subject subject = subjectService.updateSubject(subjectRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Subject successfully updated", subject));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        subjectService.deleteById(id);
        return ResponseEntity.ok("Subject successfully deleted");
    }
}

