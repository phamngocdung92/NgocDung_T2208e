package subject1Java.java.service.impl;

import subject1Java.java.dto.StudentDto;
import subject1Java.java.entity.Student;
import subject1Java.java.mapper.StudentMapper;
import subject1Java.java.mapper.impl.StudentMapperImpl;
import subject1Java.java.repository.StudentRepository;
import subject1Java.java.repository.StudentRepositoryReflect;
import subject1Java.java.repository.impl.StudentRepositoryImpl;
import subject1Java.java.service.StudentService;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository = new StudentRepositoryImpl();
    StudentMapper studentMapper = new StudentMapperImpl();
    StudentRepositoryReflect studentRepository1 = new StudentRepositoryReflect(Student.class);
    @Override
    public List<StudentDto> findAll(){
        List<Student> students = studentRepository1.findAll();
        return students.stream().map(studentMapper::entityToDto).collect(Collectors.toList());
    }
    public static void main(String[]args){
        List<String> strs = Arrays.asList("1", "2", "3");
        strs.forEach(System.err::println);
        List<Student> students = new ArrayList<>();
        List<String> strName = new ArrayList<>();
        for (Student s : students){
            strName.add(s.getFirstname());
        }
        List<String> strName1 = students.stream().map(Student::getFirstname).collect(Collectors.toList());
    }
    @Override
    public StudentDto getById(Long id){
        Optional <List<Student>> optionalStudents = studentRepository.getById(String.valueOf(id));
        if(optionalStudents.isPresent()){
            List<Student> students = optionalStudents.get();
            if(!CollectionUtils.isEmpty(students)){
                return studentMapper.entityToDto(students.get(0));
            }
        }
        return null;
    }
    @Override
    public StudentDto getByFirstName(String firstName){
        Optional<List<Student>> optionalStudents = studentRepository.getByFirstName(firstName);
        if(optionalStudents.isPresent()){
            List<Student> students = optionalStudents.get();
            if(!CollectionUtils.isEmpty(students)){
                return studentMapper.entityToDto(students.get(0));
            }
        }
        return null;
    }
    @Override
    public StudentDto getByLastName(String lastName){
        Optional<List<Student>> optionalStudents = studentRepository.getByLastName(lastName);
        if(optionalStudents.isPresent()){
            List<Student> students = optionalStudents.get();
            if(!CollectionUtils.isEmpty(students)){
                return studentMapper.entityToDto(students.get(0));
            }
        }
        return null;
    }
}
