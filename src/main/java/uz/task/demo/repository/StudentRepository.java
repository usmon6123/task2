package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.task.demo.entity.Student;
import uz.task.demo.entity.University;
import uz.task.demo.payload.StudentCountGroup;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    //guruhdagi studentlar listinini qaytaradi
    @Query(value = "select * from student s where s.group1_id = :groupId",nativeQuery = true)
    List<Student> findAllByGroupId(@Param("groupId")Integer groupId );

    @Query(value = "select count(*) from student as s where s.group1_id = :groupId",nativeQuery = true)
    Integer countStudentByGroupId(@Param("groupId") Integer groupId);

    List<Student> findAllByName(String name);
}
