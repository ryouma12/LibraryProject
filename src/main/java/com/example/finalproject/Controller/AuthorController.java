package com.example.finalproject.Controller;

import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/author")
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping(value = "/authorList")
    public ResponseEntity<BaseResponse<List<AuthorDto>>> getAuthorInfo() {
        List<AuthorDto> authorDtos = authorService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "author list successfully retrieved", authorDtos));
    }

    @GetMapping(value = "/getAuthorById/{id}")
    public ResponseEntity<BaseResponse<AuthorDto>> getAuthorById(@PathVariable(value = "id") Long id) {
        AuthorDto authorDto = authorService.getAuthorById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "author successfully retrieved", authorDto));
    }

    @PostMapping(value = "/saveAuthor")
    public ResponseEntity<BaseResponse<Author>> saveAuthor(@RequestBody AuthorRequest authorRequest) {
        Author author = authorService.saveAuthor(authorRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "author successfully saved", author));
    }

    @PutMapping(value = "/updateAuthor")
    public ResponseEntity<BaseResponse<Author>> updateCity(@RequestBody AuthorRequest authorRequest) {
        Author author = authorService.updateAuthor(authorRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "author successfully updated", author));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok("author successfully deleted");
    }
}
