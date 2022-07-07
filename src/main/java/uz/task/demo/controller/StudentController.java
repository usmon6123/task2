package uz.task.demo.controller;

import org.springframework.web.bind.annotation.*;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.FacultyReqDto;
import uz.task.demo.payload.StudentReqDto;
import uz.task.demo.utils.RestConstants;

@RequestMapping(path = RestConstants.STUDENT_CONTROLLER)
public interface StudentController {


    @PostMapping("/add")
    ApiResult<?>add(@RequestBody StudentReqDto studentReqDto);

    @GetMapping("/get-one/{id}")
    ApiResult<?> getOne(@PathVariable Integer id);

    //TALABANING KIRITILGAN YILDAGI O'QIYDIGAN FANLAR RO'YHATI
    @GetMapping("/get-subjects/{id}/{year}")
    ApiResult<?> getSubjects(@PathVariable Integer id);

    //GURUHDA O'QIYDIGAN TALABALAR RO'YHATI
    @GetMapping("/get-all-by-group-id/{groupId}")
    ApiResult<?> getAllByGroupId(@PathVariable Integer groupId);

    //FACULTEDDA O'QIYDIGAN TALABALAR RO'YHATI
    @GetMapping("/get-all-by-faculty-id/{facultyId}")
    ApiResult<?> getAllByFacultyId(@PathVariable Integer facultyId);

    @PutMapping("/edit/{id}")
    ApiResult<?>edit(@PathVariable Integer id,@RequestBody StudentReqDto studentReqDto);

    @DeleteMapping("/delete/{id}")
    ApiResult<?>delete(@PathVariable Integer id);





}
