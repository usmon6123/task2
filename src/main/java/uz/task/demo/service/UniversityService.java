package uz.task.demo.service;

import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.UniverReqDto;
import uz.task.demo.payload.UniverResDto;

public interface UniversityService {

    ApiResult<UniverResDto> add(UniverReqDto univerReqDto);

    ApiResult<UniverResDto> getOne(Integer id);

    ApiResult<?> edit(Integer id, UniverReqDto univerReqDto);

    ApiResult<?> delete(Integer id);
}
