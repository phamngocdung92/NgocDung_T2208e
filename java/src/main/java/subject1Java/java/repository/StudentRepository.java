package subject1Java.java.repository;

import subject1Java.java.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<List<Student>> getById(String id);
    List<Student> getAll();
    Optional<List<Student>> getByFirstName(String firstName);
    Optional<List<Student>> getByLastName(String lastName);
    String add(Student student);
}