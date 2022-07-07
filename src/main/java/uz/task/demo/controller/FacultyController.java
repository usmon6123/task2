package uz.task.demo.controller;

import org.springframework.web.bind.annotation.*;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.FacultyReqDto;
import uz.task.demo.payload.UniverReqDto;
import uz.task.demo.payload.UniverResDto;
import uz.task.demo.utils.RestConstants;

@RequestMapping(path = RestConstants.FACULTY_CONTROLLER)
public interface FacultyController {


    @PostMapping("/add")
    ApiResult<?>add(@RequestBody FacultyReqDto facultyReqDto);

    @GetMapping("/get-one/{id}")
    ApiResult<?> getOne(@PathVariable Integer id);

    @GetMapping("/get-all-by-univer-id/{universityId}")
    ApiResult<?> getAll(@PathVariable Integer universityId);

    @PutMapping("/edit/{id}")
    ApiResult<?>edit(@PathVariable Integer id,@RequestBody FacultyReqDto facultyReqDto);

    @DeleteMapping("/delete/{id}")
    ApiResult<?>delete(@PathVariable Integer id);





}
