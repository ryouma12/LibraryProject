package com.example.finalproject.service;

import com.example.finalproject.Dto.CopyStatDto;
import com.example.finalproject.Dto.request.CopyStatRequest;
import com.example.finalproject.Model.CopyStat;

import java.util.List;

public interface CopyStatService {
    CopyStatDto getCopyStatById(Long id);
    CopyStat saveCopyStat(CopyStatRequest copyStatRequest);
    CopyStat updateCopyStat(CopyStatRequest copyStatRequest);
    List<CopyStatDto> getAll();
    void deleteById(Long id);
}
