package com.example.finalproject.mapper;


import com.example.finalproject.Dto.AuthorDto;
import com.example.finalproject.Dto.PublisherDto;
import com.example.finalproject.Dto.request.AuthorRequest;
import com.example.finalproject.Dto.request.PublisherRequest;
import com.example.finalproject.Model.Author;
import com.example.finalproject.Model.Publisher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    Publisher toEntity(PublisherRequest publisherRequest);
    PublisherDto toDto(Publisher publisher);
    Publisher toEntity(PublisherDto publisherDto);
    List<PublisherDto> toDto(List<Publisher> publishers);
    List<Publisher> toEntity(List<PublisherDto> publisherDtos);
}
