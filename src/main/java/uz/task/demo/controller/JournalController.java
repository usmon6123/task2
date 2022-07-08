package uz.task.demo.controller;

import org.springframework.web.bind.annotation.*;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.FacultyReqDto;
import uz.task.demo.payload.JournalReqDto;
import uz.task.demo.utils.RestConstants;

@RequestMapping(path = RestConstants.JOURNAL_CONTROLLER)
public interface JournalController {

    @PostMapping("/add")
    ApiResult<?>add(@RequestBody JournalReqDto journalReqDto);

    @GetMapping("/get-one/{id}")
    ApiResult<?> getOne(@PathVariable Integer id);

    @GetMapping("/get-all")
    ApiResult<?> getAll();

    @DeleteMapping("/delete/{id}")
    ApiResult<?>delete(@PathVariable Integer id);

}
