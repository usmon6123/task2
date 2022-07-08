package uz.task.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.task.demo.payload.*;
import uz.task.demo.service.GroupService;
import uz.task.demo.service.JournalService;

@RestController
@RequiredArgsConstructor
public class JournalControllerImpl implements JournalController {

    private final JournalService journalService;

    @Override
    public ApiResult<?> add(JournalReqDto journalReqDto) {
        return journalService.add(journalReqDto);
    }

    @Override
    public ApiResult<?> getOne(Integer id) {
        return journalService.getOne(id);
    }

    @Override
    public ApiResult<?> getAll() {
        return journalService.getAll();
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        return journalService.delete(id);
    }
}
