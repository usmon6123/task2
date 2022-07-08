package uz.task.demo.service;

import uz.task.demo.payload.*;

import java.util.List;

public interface SubjectService {

    ApiResult<SubjectResDto> add(SubjectReqDto subjectReqDto);

    ApiResult<SubjectResDto> getOne(Integer id);

    ApiResult<SubjectDtoForGroup> getAllByGroupId(Integer groupId);

    ApiResult<List<SubjectResDto>> getAll();

    ApiResult<?> edit(Integer id, SubjectReqDto subjectReqDto);

    ApiResult<?> delete(Integer id);

}
