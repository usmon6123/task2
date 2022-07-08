package uz.task.demo.service;

import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.StudentOneReqDto;
import uz.task.demo.payload.StudentReqDto;

public interface StudentService {

    ApiResult<?> add(StudentReqDto studentReqDto);

    ApiResult<?> getOne(Integer id);

    ApiResult<?> getSubjects(Integer id);

    ApiResult<?> getAllByGroupId(Integer groupId);

    ApiResult<?> getAllByFacultyId(Integer facultyId);

    ApiResult<?> getInfoStudents(String name);

    ApiResult<?> edit(Integer id, StudentOneReqDto studentReqDto);

    ApiResult<?> delete(Integer id);

}
