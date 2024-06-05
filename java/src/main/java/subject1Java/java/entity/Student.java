package subject1Java.java.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import subject1Java.java.jpaRepository.annotation.Column;
import subject1Java.java.jpaRepository.annotation.Entity;
import subject1Java.java.jpaRepository.annotation.Id;

@Getter
@Setter
@Builder
//@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(tableName = "student")
public class Student {
    @Id(name = "Id")
    private Long id;
    @Column(columnName = "First_name")
    private String firstname;
    @Column(columnName = "Last_name")
    private String lastname;
    @Column(columnName = "Address")
    private String address;
    @Column(columnName = "Age")
    private int age;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getFirstname(){
        return firstname;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String toString(){
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}