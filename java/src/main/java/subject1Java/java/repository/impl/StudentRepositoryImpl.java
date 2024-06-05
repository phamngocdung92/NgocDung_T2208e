package subject1Java.java.repository.impl;

import subject1Java.java.entity.Student;
import subject1Java.java.repository.StudentRepository;
import subject1Java.java.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository{
    private static final String SQL_QUERY_STUDENT_BY_ID = "SELECT * FROM student WHERE id = ?";
    private static final String SQL_QUERY_STUDENT_BY_FIRSTNAME = "SELECT * FROM student WHERE first_name like ?";
    private static final String SQL_QUERY_STUDENT_BY_LASTNAME = "SELECT * FROM student WHERE Last_name like ?";
    @Override
    public Optional<List<Student>> getById(String id){
        List<Student> students = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        try{
            PreparedStatement pt = con.prepareStatement(SQL_QUERY_STUDENT_BY_ID);
            pt.setString(1, String.valueOf(id));
            ResultSet rs = pt.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getLong("id"));
                s.setFirstname(rs.getString("First_name"));
                s.setLastname(rs.getString("Last_name"));
                s.setAddress(rs.getString("address"));
                s.setAge(rs.getInt("age"));
                students.add(s);
            }
        } catch (SQLException e){
            throw new RuntimeException("Error when querying student by id", e);
        }
        return Optional.of(students);
    }
    @Override
    public List<Student> getAll(){
        return List.of();
    }
    @Override
    public Optional<List<Student>> getByFirstName(String firstName){
        List<Student> students = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        try {
            PreparedStatement pt = con.prepareStatement(SQL_QUERY_STUDENT_BY_FIRSTNAME);
            pt.setString(1, firstName + "%");
            ResultSet rs = pt.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getLong("id"));
                s.setFirstname(rs.getString("First_name"));
                s.setLastname(rs.getString("Last_name"));
                s.setAddress(rs.getString("address"));
                s.setAge(rs.getInt("age"));
                students.add(s);
            }
        } catch (SQLException e){
            throw new RuntimeException("Error when querying student by first name", e);
        }
        return Optional.of(students);
    }
    @Override
    public Optional<List<Student>> getByLastName(String lastName){
        List<Student> students = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection con = connectionPool.getConnection();
        try {
            PreparedStatement pt = con.prepareStatement(SQL_QUERY_STUDENT_BY_LASTNAME);
            pt.setString(1, lastName + "%");
            ResultSet rs = pt.executeQuery();
            while (rs.next()){
                Student s = new Student();
                s.setId(rs.getLong("id"));
                s.setFirstname(rs.getString("First_name"));
                s.setLastname(rs.getString("Last_name"));
                s.setAddress(rs.getString("address"));
                s.setAge(rs.getInt("age"));
                students.add(s);
            }
        } catch (SQLException e){
            throw new RuntimeException("Error when querying student by last name", e);
        }
        return Optional.of(students);
    }
}