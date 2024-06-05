package subject1Java.java.repository;

import subject1Java.java.entity.Student;
import subject1Java.java.jpaRepository.main.impl.JpaExecutorImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryReflect extends JpaExecutorImpl<Student>{
    public StudentRepositoryReflect(Class<Student> clazz) {
        super(clazz);
    }
    public static void main(String[]args){
        StudentRepositoryReflect repo = new StudentRepositoryReflect(Student.class);
        repo.findAll();
    }
    @Override
    public List<Student> rowMapper(ResultSet rs) {
        List<Student> students = new ArrayList<>();
        try {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getLong("id"));
                s.setFirstname(rs.getString("First_name"));
                s.setLastname(rs.getString("Last_name"));
                s.setAddress(rs.getString("address"));
                s.setAge(rs.getInt("age"));
                students.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}