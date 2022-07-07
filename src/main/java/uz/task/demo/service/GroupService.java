package uz.task.demo.service;

import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.CustomPage;
import uz.task.demo.payload.GroupReqDto;

public interface GroupService {
    ApiResult<?> add(GroupReqDto groupReqDto);

    ApiResult<?> getOne(Integer id);

    ApiResult<CustomPage<?>> getAllByFaculty(Integer facultyId, int page, int size);

    ApiResult<CustomPage<?>> getAllByUniverInYear(Integer facultyId, int openYear, int page, int size);

    ApiResult<?> edit(Integer id, GroupReqDto groupReqDto);

    ApiResult<?> delete(Integer id);

}
