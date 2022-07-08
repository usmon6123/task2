package uz.task.demo.service;

import uz.task.demo.payload.*;

public interface GroupService {
    ApiResult<?> add(GroupReqDto groupReqDto);

    ApiResult<?> getOne(Integer id);

    ApiResult<CustomPage<?>> getAllByFaculty(Integer facultyId, int page, int size);

    ApiResult<?> attachSubjectsToGroup(SubjectListFromGroup subjectListFromGroup);

    ApiResult<CustomPage<?>> getAllByUniverInYear(Integer facultyId, int openYear, int page, int size);

    ApiResult<?> edit(Integer id, GroupReqDto groupReqDto);

    ApiResult<?> delete(Integer id);


}
