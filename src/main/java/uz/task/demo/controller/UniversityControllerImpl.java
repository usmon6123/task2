package uz.task.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.UniverReqDto;
import uz.task.demo.payload.UniverResDto;
import uz.task.demo.service.UniversityService;

@RestController
@RequiredArgsConstructor
public class UniversityControllerImpl implements UniversityController{
    private final UniversityService universityService;

    @Override
    public ApiResult<UniverResDto> add(UniverReqDto univerReqDto) {
        return universityService.add(univerReqDto);
    }

    @Override
    public ApiResult<UniverResDto> getOne(Integer id) {
        return universityService.getOne(id);
    }

    @Override
    public ApiResult<?> edit(Integer id, UniverReqDto univerReqDto) {
        return universityService.edit(id,univerReqDto);
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        return universityService.delete(id);
    }
}
