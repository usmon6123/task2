package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.task.demo.entity.Group1;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group1, Integer> {

    boolean existsByNameAndYearAndActiveTrue(String name, int year);

    Optional<Group1> findByIdAndActiveTrue(Integer id);

    @Query(value = "select count(*)>0 from journal as g where g.group1_id = :groupId",nativeQuery = true)
    boolean exists(@Param("groupId") Integer groupId);
}
