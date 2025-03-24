package com.JpaConnection.demo.Controller;

import com.JpaConnection.demo.Module.Student;
import com.JpaConnection.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService ;

    @GetMapping("/student")
    public List<Student> getallstudent(){
        return studentService.getallstudent();
    }

    @PostMapping("/student")
    public ResponseEntity<String>addStudent(@RequestBody Student student){
         studentService.addStudent(student);
         return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/student/delete/{id}")
    public String delete(@RequestBody @PathVariable("id") int id){
        studentService.delete(id);
        return  id + " " + "Deleted Successfully";
    }

    @DeleteMapping("/student/deleteall")
    public String deleteall(){
        studentService.deleteAll();
        return "Dropped Database";
    }

    @PutMapping("/student/update")
    public String update(@RequestBody Student student){
        studentService.update(student);
        return "Updated Successfully";
    }

    @GetMapping("/student/filter/{dept}")
    public List<Student> getbydepartment(@PathVariable("dept") String dept){
        return studentService.filter(dept);
    }

    @PostMapping("/student/filter/")
    public List<Student> getbyDepartmentandPlace(@Param("dept")String dept,@Param("place") String place){
        return studentService.getByDepartmentandPlace(dept,place);
    }

}