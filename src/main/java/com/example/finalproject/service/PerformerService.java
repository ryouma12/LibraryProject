package com.example.finalproject.service;

import com.example.finalproject.Dto.PatronDto;
import com.example.finalproject.Dto.PerformerDto;
import com.example.finalproject.Dto.request.PatronRequest;
import com.example.finalproject.Dto.request.PerformerRequest;
import com.example.finalproject.Model.Patron;
import com.example.finalproject.Model.Performer;

import java.util.List;

public interface PerformerService {
    PerformerDto getPerformerById(Long id);
    Performer savePerformer(PerformerRequest performerRequest);
    Performer updatePerformer(PerformerRequest performerRequest);
    List<PerformerDto> getAll();
    void deleteById(Long id);
}
