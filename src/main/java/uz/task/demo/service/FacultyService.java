package uz.task.demo.service;

import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.FacultyReqDto;

public interface FacultyService {
    ApiResult<?> add(FacultyReqDto facultyReqDto);

    ApiResult<?> getOne(Integer id);

    ApiResult<?> getAll(Integer universityId);

    ApiResult<?> edit(Integer id, FacultyReqDto facultyReqDto);

    ApiResult<?> delete(Integer id);
}
