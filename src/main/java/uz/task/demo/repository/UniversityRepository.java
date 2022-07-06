package uz.task.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.task.demo.entity.University;

public interface UniversityRepository extends JpaRepository<University,Integer> {
    boolean existsByName(String name);

    //O'ZINING IDSIDAN BOSHQA IDLI BO'LGAN UNIVERSITYNI NOMI BILAN BIR XIL BO'B QOSA TRUE QAYTARADI
    @Query(value = "select count(*)>0 from university as u where (u.id !=:id and u.name = :name )",nativeQuery = true)
    boolean uniqueByName(@Param("id")Integer id,@Param("name")String name);

    //ICHIDA FAKULTEDI BOR UNIVER BO'LSA TRUE QAYTARADI
    @Query(value = "select count(*)>0 from faculty as f where f.university_id = :id",nativeQuery = true)
    boolean existsUniverFaculty(@Param("id") Integer id);
}
