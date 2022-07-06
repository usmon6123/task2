package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.task.demo.entity.Student;
import uz.task.demo.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
