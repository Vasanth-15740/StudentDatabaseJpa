package com.JpaConnection.demo.Service;
import com.JpaConnection.demo.Repository.StudentInterface;
import com.JpaConnection.demo.Module.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentService {
    @Autowired
    StudentInterface studentInterface;

    public void addStudent(Student student) {
        studentInterface.save(student);
    }

    public List<Student> getallstudent(){
        return studentInterface.findAll();
    }

    public void delete(int id){
        studentInterface.deleteById(id);
    }

    public void update(Student student){
        studentInterface.save(student);
    }

    public List<Student> filter(String dept) {
       return studentInterface.findByDept(dept);
    }

    public List<Student> getByDepartmentandPlace(String dept, String place) {
        return studentInterface.findByDeptAndPlace(dept,place);
    }
}
