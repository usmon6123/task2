package uz.task.demo.controller;

import org.springframework.web.bind.annotation.*;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.CustomPage;
import uz.task.demo.payload.FacultyReqDto;
import uz.task.demo.payload.GroupReqDto;
import uz.task.demo.utils.RestConstants;

import static uz.task.demo.utils.RestConstants.*;

@RequestMapping(path = RestConstants.GROUP_CONTROLLER)
public interface GroupController {


    @PostMapping("/add")
    ApiResult<?> add(@RequestBody GroupReqDto groupReqDto);

    @GetMapping("/get-one/{id}")
    ApiResult<?> getOne(@PathVariable Integer id);

    //Facultedda
    @GetMapping("/get-all-by-faculty-id/{facultyId}")
    ApiResult<CustomPage<?>>getAllByFaculty(@PathVariable Integer facultyId,
                                            @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER) int page,
                                            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size);


    //UNIVERSITEDGA KIRITILGAN YILDA OCHILGAN GURUHLAR RO'YHATINI QAYTARDI
    @GetMapping("/get-all-by-univer-id-in-year/{facultyId}/{openYear}")
    ApiResult<CustomPage<?>> getAllByUniverInYear(@PathVariable Integer facultyId,
                                @PathVariable int openYear,
                                @RequestParam(defaultValue = DEFAULT_PAGE_NUMBER) int page,
                                @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int size);

    @PutMapping("/edit/{id}")
    ApiResult<?> edit(@PathVariable Integer id, @RequestBody GroupReqDto groupReqDto);

    @DeleteMapping("/delete/{id}")
    ApiResult<?> delete(@PathVariable Integer id);


}
