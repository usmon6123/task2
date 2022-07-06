package uz.task.demo.controller;

import org.springframework.web.bind.annotation.*;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.UniverReqDto;
import uz.task.demo.payload.UniverResDto;
import uz.task.demo.utils.RestConstants;

@RequestMapping(path = RestConstants.UNIVERSITY_CONTROLLER)
public interface UniversityController {


    @PostMapping("/add")
    ApiResult<UniverResDto>add(@RequestBody UniverReqDto univerReqDto);

    @GetMapping("/get-one/{id}")
    ApiResult<UniverResDto> getOne(@PathVariable Integer id);

    @PutMapping("/edit/{id}")
    ApiResult<?>edit(@PathVariable Integer id,@RequestBody UniverReqDto univerReqDto);

    @DeleteMapping("/delete/{id}")
    ApiResult<?>delete(@PathVariable Integer id);

}
