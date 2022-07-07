package uz.task.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.CustomPage;
import uz.task.demo.payload.GroupReqDto;
import uz.task.demo.service.GroupService;

@RestController
@RequiredArgsConstructor
public class GroupControllerImpl implements GroupController {

    private final GroupService groupService;

    @Override
    public ApiResult<?> add(GroupReqDto groupReqDto) {
        return groupService.add(groupReqDto);
    }

    @Override
    public ApiResult<?> getOne(Integer id) {
        return groupService.getOne(id);
    }

    @Override
    public ApiResult<CustomPage<?>> getAllByFaculty(Integer facultyId, int page, int size) {
        return groupService.getAllByFaculty(facultyId,page,size);
    }

    @Override
    public ApiResult<CustomPage<?>> getAllByUniverInYear(Integer facultyId, int openYear, int page, int size) {
        return groupService.getAllByUniverInYear(facultyId,openYear,page,size);
    }

    @Override
    public ApiResult<?> edit(Integer id, GroupReqDto groupReqDto) {
        return groupService.edit(id,groupReqDto);
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        return groupService.delete(id);
    }
}
