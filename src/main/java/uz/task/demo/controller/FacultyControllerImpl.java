package uz.task.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.FacultyReqDto;
import uz.task.demo.service.FacultyService;

@RestController
@RequiredArgsConstructor
public class FacultyControllerImpl implements FacultyController {

    private final FacultyService facultyService;

    @Override
    public ApiResult<?> add(FacultyReqDto facultyReqDto) {
        return facultyService.add(facultyReqDto);
    }

    @Override
    public ApiResult<?> getOne(Integer id) {
        return facultyService.getOne(id);
    }

    @Override
    public ApiResult<?> getAll(Integer universityId) {
        return facultyService.getAll(universityId);
    }

    @Override
    public ApiResult<?> edit(Integer id, FacultyReqDto facultyReqDto) {
        return facultyService.edit(id, facultyReqDto);
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        return facultyService.delete(id);
    }
}
