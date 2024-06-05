package subject1Java.java.mapper;

import subject1Java.java.dto.StudentDto;
import subject1Java.java.entity.Student;

public interface StudentMapper {
    Student dtoToEntity(StudentDto studentDto);
    StudentDto entityToDto(Student student);
}