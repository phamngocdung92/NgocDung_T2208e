package subject1Java.java.controller;

import subject1Java.java.dto.StudentDto;
import subject1Java.java.service.StudentService;
import subject1Java.java.service.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    StudentService studentService = new StudentServiceImpl();
    @GetMapping(value = "/students/{studentId}")
    public StudentDto get(@PathVariable Long studentId) {
        return studentService.getById(studentId);
    }
    @GetMapping(value = "/students")
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }
    @GetMapping(value = "/students/firstname/{firstName}")
    public StudentDto getByFirstName(@PathVariable String firstName) {
        return studentService.getByFirstName(firstName);
    }
    @GetMapping(value = "/students/lastname/{lastName}")
    public StudentDto getByLastName(@PathVariable String lastName) {
        return studentService.getByLastName(lastName);
    }
}