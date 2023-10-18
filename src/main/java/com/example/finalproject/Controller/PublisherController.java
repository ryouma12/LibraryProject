package com.example.finalproject.Controller;

import com.example.finalproject.Dto.PublisherDto;
import com.example.finalproject.Dto.request.PublisherRequest;
import com.example.finalproject.Model.Publisher;
import com.example.finalproject.Model.response.BaseResponse;
import com.example.finalproject.service.Impl.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping(value = "/publisherList")
    public ResponseEntity<BaseResponse<List<PublisherDto>>>
    getPublisherInfo() {
        List<PublisherDto> publisherDtos = publisherService.getAll();
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Publisher list successfully retrieved", publisherDtos));
    }

    @GetMapping(value = "/getPublisherById/{id}")
    public ResponseEntity<BaseResponse<PublisherDto>>
    getPublisherById(@PathVariable(value = "id") Long id) {
        PublisherDto publisherDto = publisherService.getPublisherById(id);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Publisher successfully retrieved", publisherDto));
    }

    @PostMapping(value = "/savePublisher")
    public ResponseEntity<BaseResponse<Publisher>>
    savePublisher(@RequestBody PublisherRequest publisherRequest) {
        Publisher publisher = publisherService.savePublisher(publisherRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Publisher successfully saved", publisher));
    }

    @PutMapping(value = "/updatePublisher")
    public ResponseEntity<BaseResponse<Publisher>>
    updatePublisher(@RequestBody PublisherRequest publisherRequest) {
        Publisher publisher = publisherService.updatePublisher(publisherRequest);
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE, "Publisher successfully updated", publisher));
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<String>
    deleteById(@PathVariable(value = "id") Long id) {
        publisherService.deleteById(id);
        return ResponseEntity.ok("Publisher successfully deleted");
    }
}

