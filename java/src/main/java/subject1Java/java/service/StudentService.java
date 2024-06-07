package subject1Java.java.service;

import subject1Java.java.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto getById(Long id);
    List<StudentDto> findAll();
    StudentDto getByFirstName(String firstName);
    StudentDto getByLastName(String lastName);
    String add(StudentDto studentDto);
}