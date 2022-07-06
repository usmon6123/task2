package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.task.demo.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
