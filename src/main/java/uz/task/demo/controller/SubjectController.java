package uz.task.demo.controller;

import org.springframework.web.bind.annotation.*;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.FacultyReqDto;
import uz.task.demo.payload.SubjectReqDto;
import uz.task.demo.utils.RestConstants;

@RequestMapping(path = RestConstants.SUBJECT_CONTROLLER)
public interface SubjectController {


    @PostMapping("/add")
    ApiResult<?>add(@RequestBody SubjectReqDto subjectReqDto);

    @GetMapping("/get-one/{id}")
    ApiResult<?> getOne(@PathVariable Integer id);

    //GURUHGA KIRITILGAN YILDA O'TADIGAN FANLAR RO'YHAT
    @GetMapping("/get-all-by-group/{groupId}")
    ApiResult<?> getAllByGroupId(@PathVariable Integer groupId);

    @GetMapping("/get-all")
    ApiResult<?> getAll();

    @PutMapping("/edit/{id}")
    ApiResult<?>edit(@PathVariable Integer id,@RequestBody SubjectReqDto subjectReqDto);

    @DeleteMapping("/delete/{id}")
    ApiResult<?>delete(@PathVariable Integer id);

}
