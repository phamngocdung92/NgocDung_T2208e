package subject1Java.java.mapper.impl;

import subject1Java.java.dto.StudentDto;
import subject1Java.java.entity.Student;
import subject1Java.java.mapper.StudentMapper;
import org.springframework.beans.BeanUtils;

public class StudentMapperImpl implements StudentMapper{
    @Override
    public Student dtoToEntity(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        return student;
    }

    @Override
    public StudentDto entityToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student, studentDto);
        return studentDto;
    }
}