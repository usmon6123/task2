package uz.task.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.task.demo.payload.*;
import uz.task.demo.service.GroupService;
import uz.task.demo.service.SubjectService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubjectControllerImpl implements SubjectController {

    private final SubjectService subjectService;

    @Override
    public ApiResult<SubjectResDto> add(SubjectReqDto subjectReqDto) {
        return subjectService.add(subjectReqDto);
    }

    @Override
    public ApiResult<SubjectResDto> getOne(Integer id) {
        return subjectService.getOne(id);
    }

    @Override
    public ApiResult<SubjectDtoForGroup> getAllByGroupId(Integer groupId, int year) {
        return subjectService.getOneByGroupId(groupId,year);
    }

    @Override
    public ApiResult<List<SubjectResDto>> getAll(Integer universityId) {
        return subjectService.getAll(universityId);
    }

    @Override
    public ApiResult<?> edit(Integer id, SubjectReqDto subjectReqDto) {
        return subjectService.edit(id,subjectReqDto);
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        return subjectService.delete(id);
    }
}
