package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.task.demo.entity.Journal;
import uz.task.demo.entity.Subject;

public interface JournalRepository extends JpaRepository<Journal,Integer> {
}
