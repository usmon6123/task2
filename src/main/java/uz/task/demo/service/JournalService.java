package uz.task.demo.service;

import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.JournalReqDto;

public interface JournalService {

    ApiResult<?> add(JournalReqDto journalReqDto);

    ApiResult<?> getOne(Integer id);

    ApiResult<?> getAll();

    ApiResult<?> delete(Integer id);

}
