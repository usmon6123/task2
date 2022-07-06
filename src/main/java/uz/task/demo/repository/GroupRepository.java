package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.task.demo.entity.Group1;

public interface GroupRepository extends JpaRepository<Group1,Integer> {
}
