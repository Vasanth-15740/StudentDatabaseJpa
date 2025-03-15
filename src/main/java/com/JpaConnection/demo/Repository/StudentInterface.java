package com.JpaConnection.demo.Repository;
import com.JpaConnection.demo.Module.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentInterface extends JpaRepository<Student, Integer> {

    List<Student>findByDept(String dept);

    @Query(nativeQuery = true,value = "select*from student where dept=:dept and place=:place")
    List<Student> findByDeptAndPlace(@Param("dept")String dept, @Param("place") String place);

}
