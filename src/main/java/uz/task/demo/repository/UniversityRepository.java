package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.task.demo.entity.University;

public interface UniversityRepository extends JpaRepository<University,Integer> {
}
