package com.example.finalproject.service;

import com.example.finalproject.Dto.StateDto;
import com.example.finalproject.Dto.SubjectDto;
import com.example.finalproject.Dto.request.StateRequest;
import com.example.finalproject.Dto.request.SubjectRequest;
import com.example.finalproject.Model.State;
import com.example.finalproject.Model.Subject;

import java.util.List;

public interface SubjectService {
    SubjectDto getSubjectById(Long id);
    Subject saveSubject(SubjectRequest subjectRequest);
    Subject updateSubject(SubjectRequest subjectRequest);
    List<SubjectDto> getAll();
    void deleteById(Long id);
}
