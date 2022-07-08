package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.task.demo.entity.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {


//    boolean existsByName(String name);

    @Query(value = "select count(*)>0 from faculty as u where (u.id !=:id and u.name = :name )",nativeQuery = true)
    boolean existsByName(@Param("id")Integer id,@Param("name")String name);

    List<Faculty> findAllByUniversity_Id(Integer university_id);

    @Query(value = "select count(*)>0 from group1 as g where g.faculty_id = :facultyId",nativeQuery = true)
    boolean isHavingGroup(@Param("facultyId") Integer id);
}
