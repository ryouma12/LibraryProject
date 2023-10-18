package com.example.finalproject.Controller;

import com.example.finalproject.Dto.LibrarianDto;
import com.example.finalproject.Dto.request.LibrarianRequest;
import com.example.finalproject.Model.Librarian;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.LibrarianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/librarian")
public class LibrarianController {

    private final LibrarianService librarianService;

    @GetMapping(value = "/librarianList")
    public ResponseEntity<BaseResponse<List<LibrarianDto>>>
    getLibrarianInfo() {
        List<LibrarianDto> librarianDtos = librarianService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Librarian list successfully retrieved", librarianDtos));
    }

    @GetMapping(value = "/getLibrarianById/{id}")
    public ResponseEntity<BaseResponse<LibrarianDto>>
    getLibrarianById(@PathVariable(value = "id") Long id) {
        LibrarianDto librarianDto = librarianService.getLibrarianById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Librarian successfully retrieved", librarianDto));
    }

    @PostMapping(value = "/saveLibrarian")
    public ResponseEntity<BaseResponse<Librarian>>
    saveLibrarian(@RequestBody LibrarianRequest librarianRequest) {
        Librarian librarian = librarianService.saveLibrarian(librarianRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Librarian successfully saved", librarian));
    }

    @PutMapping(value = "/updateLibrarian")
    public ResponseEntity<BaseResponse<Librarian>>
    updateLibrarian(@RequestBody LibrarianRequest librarianRequest) {
        Librarian librarian = librarianService.updateLibrarian(librarianRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Librarian successfully updated", librarian));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        librarianService.deleteById(id);
        return ResponseEntity.ok("Librarian successfully deleted");
    }
}

