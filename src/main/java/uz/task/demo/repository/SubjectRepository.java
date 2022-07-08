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
    @Query(value = "select * from subject as s where s.id in (select g.subject_list_id from group1_subject_list  g where g.group1_id = :groupId)",nativeQuery = true)
    List<Subject> findAllByGroupId(@Param("groupId") Integer groupId);

    //BU FAN GURUHLARGA O'TILAYOTGAN BO'LSA TRUE QAYTARADI
    @Query(value = "select count(*)>0 from journal_subjects as js where js.subjects_id = :id",nativeQuery = true)
    boolean existsForDelete(@Param("id") Integer id);

    @Query(value = "select count(*)>0 from subject as u where (u.id !=:id and u.name = :name )",nativeQuery = true)
    boolean existsUniqueName(@Param("id")Integer id,@Param("name")String name);


    //STUDENTNING O'QIYDIGAN FANLAR RO'YHATI
    @Query(value = "select * from subject as s where s.id in (\n" +
            "    select gs.subject_list_id from group1_subject_list as gs\n" +
            "               where gs.group1_id = (select st.group1_id from student as st\n" +
            "                   where st.id = :studentId))",nativeQuery = true)
    List<Subject> findAllByStudentId(@Param("studentId") Integer studentId);



}
