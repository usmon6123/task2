package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.task.demo.entity.Student;
import uz.task.demo.entity.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    boolean existsByName(String name);

    //GURUHNING KIRITILGAN YILDAGI OTADIGAN FANLAR ROYHATI
    @Query(value = "select * from subject as s where s.id in(" +
            "select js.subjects_id from journal_subjects as js where js.journal_id in (" +
            "select j.id from journal as j where (" +
            "j.group1_id = :groupId and j.year = :year)))",nativeQuery = true)
    List<Subject> findAllByGroupId(@Param("groupId") Integer groupId,
                                   @Param("year")int year);

    //BU FAN GURUHLARGA O'TILAYOTGAN BO'LSA TRUE QAYTARADI
    @Query(value = "select count(*)>0 from journal_subjects as js where js.subjects_id = :id",nativeQuery = true)
    boolean existsForDelete(@Param("id") Integer id);
}
