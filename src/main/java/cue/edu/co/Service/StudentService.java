package cue.edu.co.Service;

import cue.edu.co.mapping.dtos.StudentDto;

import java.util.List;

public interface StudentService<T> {
    List<T> listStudent();
}