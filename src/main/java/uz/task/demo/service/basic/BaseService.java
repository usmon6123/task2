package uz.task.demo.service.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.task.demo.entity.Faculty;
import uz.task.demo.entity.Group1;
import uz.task.demo.entity.Subject;
import uz.task.demo.entity.University;
import uz.task.demo.exception.RestException;
import uz.task.demo.repository.*;

@Service
@RequiredArgsConstructor
public class BaseService {
    private final UniversityRepository universityRepository;
    private final FacultyRepository facultyRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final JournalRepository journalRepository;
    private final SubjectRepository subjectRepository;


    //ID ORQALI UNIVERSITEDNI BAZADAN OLIBERADI TOPOLMASA THROW
    public  University getUniversityOrElseThrowById(Integer id) {
        return universityRepository.findById(id).orElseThrow(() -> RestException.notFound("UNIVERSITY NOT FOUND"));
    }

    //ID ORQALI FAKULTEDNI BAZADAN OLIBERADI TOPOLMASA THROW
    public Faculty getFacultyOrElseThrowById(Integer id){
       return facultyRepository.findById(id).orElseThrow(() -> RestException.notFound("FACULTY NOT FOUND"));
    }

    //ID ORQALI GROUPNI BAZADAN OLIBERADI TOPOLMASA THROW
    public Group1 getGroupOrElseThrowById(Integer id){
        return groupRepository.findByIdAndActiveTrue(id).orElseThrow(() -> RestException.notFound("GROUP NOT FOUND"));
    }

    //ID ORQALI SUBJECTNI BAZADAN OLIBERADI TOPOLMASA THROW
    public Subject getSubjectOrElseThrowById(Integer id){
        return subjectRepository.findById(id).orElseThrow(() -> RestException.notFound("SUBJECT NOT FOUND"));
    }


}
