package uz.task.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.task.demo.payload.*;
import uz.task.demo.service.StudentService;
import uz.task.demo.service.SubjectService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    @Override
    public ApiResult<?> add(StudentReqDto studentReqDto) {
        return studentService.add(studentReqDto);
    }

    @Override
    public ApiResult<?> getOne(Integer id) {
        return studentService.getOne(id);
    }

    /**
     * STUDENT O'QIYDIGAN FANLAR LISTINI QAYTARADIGAN YO'L
     */
    @Override
    public ApiResult<?> getSubjects(Integer id) {
        return studentService.getSubjects(id);
    }

    /**
     * GURUHDAGI TALABALAR RO'YHATINI QAYTARADI
     * @param groupId ORQALI
     */
    @Override
    public ApiResult<?> getAllByGroupId(Integer groupId) {
        return studentService.getAllByGroupId(groupId);
    }

    /**
     * FACULTED ID ORQALI GURUHLAR VA ULARDA O'QIYDIGAN TALABALAR RO'YHATINI QAYTARADIGAN YO'L
     */
    @Override
    public ApiResult<?> getAllByFacultyId(Integer facultyId) {
        return studentService.getAllByFacultyId(facultyId);
    }

    @Override
    public ApiResult<?> getInfoStudents(String name) {
        return studentService.getInfoStudents(name);
    }

    @Override
    public ApiResult<?> edit(Integer id, StudentOneReqDto studentReqDto) {
        return studentService.edit(id, studentReqDto);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ApiResult<?> delete(Integer id) {
        return studentService.delete(id);
    }
}
