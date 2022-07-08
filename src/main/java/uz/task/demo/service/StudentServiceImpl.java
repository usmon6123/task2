package uz.task.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.task.demo.entity.Group1;
import uz.task.demo.entity.Student;
import uz.task.demo.entity.Subject;
import uz.task.demo.exception.RestException;
import uz.task.demo.payload.*;
import uz.task.demo.repository.GroupRepository;
import uz.task.demo.repository.StudentRepository;
import uz.task.demo.repository.SubjectRepository;
import uz.task.demo.service.basic.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final GroupRepository groupRepository;
    private final BaseService baseService;


    @Override
    public ApiResult<?> add(StudentReqDto studentReqDto) {

        //STUDENT QOSHMOQCHI GURUHIZ BAZADA BOLSA QAYTARADI AKS HOLDA THROW
        Group1 group = baseService.getGroupOrElseThrowById(studentReqDto.getGroupId());

        //BIR GURUHGA TEGISHLI STUDENTLARNI QO'SHYAPDI
        List<Student> studentList = studentReqDto.getStudentDtoList().stream().map(studentDto -> new Student(studentDto.getName(), group)).collect(Collectors.toList());

        studentRepository.saveAll(studentList);

        return ApiResult.successResponse("SUCCESS ADDED STUDENTS");
    }

    @Override
    public ApiResult<?> getOne(Integer id) {

        //ID ORQALI STUDENTNI BAZADAN OLIBERADI TOPOLMASA THROW
        Student student = baseService.getStudentOrElseThrowById(id);

        return ApiResult.successResponse(new StudentResDto(student));
    }

    @Override
    public ApiResult<?> getSubjects(Integer id) {

        List<Subject> subjectList = subjectRepository.findAllByStudentId(id);

        List<SubjectResDto> subjectDtoList = subjectList.stream().map(SubjectResDto::new).collect(Collectors.toList());

        return ApiResult.successResponse(new StudentSubjectsDto(id, subjectDtoList));
    }

    @Override
    public ApiResult<?> getAllByGroupId(Integer groupId) {
        //GURUHDAGI TALABALAR RO'YHATINI QAYTARADI GROUPID ORQALI
        List<Student> studentList = studentRepository.findAllByGroupId(groupId);
        List<StudentIdName> nameList = studentList.stream().map(StudentIdName::new).collect(Collectors.toList());
        return ApiResult.successResponse(new StudentListByGroup(groupId, nameList));
    }

    @Override
    public ApiResult<?> getAllByFacultyId(Integer facultyId) {

        List<Group1> groupList = groupRepository.findAllByFacultyId(facultyId);
        ArrayList<StudentCountGroup> list = new ArrayList<>();

        for (Group1 group : groupList) {
            Integer count = studentRepository.countStudentByGroupId(group.getId());
            //GURUH_ID VA UNGA TEGISHLI TALABALAR ISMI VA IDSINI YIG'YAPDI
            StudentCountGroup studentCountGroup = new StudentCountGroup(group.getId(), group.getName(), count);
            list.add(studentCountGroup);
        }

        return ApiResult.successResponse(new StudentListByFaculty(facultyId,list));
    }

    @Override
    public ApiResult<?> getInfoStudents(String name) {
        List<Student> studentList = studentRepository.findAllByName(name);
        ArrayList<FindStudentInfoDto> list = new ArrayList<>();
        for (Student student : studentList) {
            Group1 group = baseService.getGroupOrElseThrowById(student.getGroup1().getId());
             list.add(new FindStudentInfoDto(
                    student.getId(),
                    student.getName(),
                    group.getId(),
                    group.getName(),
                    group.getFaculty().getId(),
                    group.getFaculty().getName()
            ));
        }

        return ApiResult.successResponse(list);
    }

    @Override
    public ApiResult<?> edit(Integer id, StudentOneReqDto studentReqDto) {

        Student student = baseService.getStudentOrElseThrowById(id);

        //STUDENT QOSHMOQCHI GURUHIZ BAZADA BOLSA QAYTARADI AKS HOLDA THROW
        Group1 group = baseService.getGroupOrElseThrowById(studentReqDto.getGroupId());

        student.setGroup1(group);
        student.setName(studentReqDto.getName() != null ?studentReqDto.getName():student.getName());
        studentRepository.save(student);

        return ApiResult.successResponse(new StudentResDto(student),"SUCCESS EDITED STUDENT");
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        try {

            studentRepository.deleteById(id);
            return ApiResult.successResponse("STUDENT SUCCESS DELETED");
        }catch (Exception e){
            e.printStackTrace();
            throw RestException.restThrow("BU STUDENTNI O'CHIRA OLMAYSIZ YOKI STUDENT TOPILMADI",HttpStatus.CONFLICT);
        }
    }
}

