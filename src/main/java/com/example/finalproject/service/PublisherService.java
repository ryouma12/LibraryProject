package com.example.finalproject.service;

import com.example.finalproject.Dto.PerformerDto;
import com.example.finalproject.Dto.PublisherDto;
import com.example.finalproject.Dto.request.PerformerRequest;
import com.example.finalproject.Dto.request.PublisherRequest;
import com.example.finalproject.Model.Performer;
import com.example.finalproject.Model.Publisher;

import java.util.List;

public interface PublisherService {
    PublisherDto getPublisherById(Long id);
    Publisher savePublisher(PublisherRequest publisherRequest);
    Publisher updatePublisher(PublisherRequest publisherRequest);
    List<PublisherDto> getAll();
    void deleteById(Long id);
}
