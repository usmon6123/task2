package uz.task.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.task.demo.entity.Faculty;
import uz.task.demo.entity.Group1;
import uz.task.demo.entity.Journal;
import uz.task.demo.entity.Subject;
import uz.task.demo.exception.RestException;
import uz.task.demo.payload.*;
import uz.task.demo.repository.GroupRepository;
import uz.task.demo.repository.JournalRepository;
import uz.task.demo.repository.SubjectRepository;
import uz.task.demo.service.basic.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JournalServiceImpl implements JournalService {
    private final JournalRepository journalRepository;
    private final SubjectRepository subjectRepository;
    private final BaseService baseService;


    @Override
    public ApiResult<?> add(JournalReqDto journalReqDto) {
        try {
            Group1 group = baseService.getGroupOrElseThrowById(journalReqDto.getGroupId());
            Journal journal = new Journal(journalReqDto.getName(), group, journalReqDto.getYear());
            journalRepository.save(journal);
            return ApiResult.successResponse(new JournalResDto(journal.getId(),journal.getName(),group.getId(),journal.getYear()));
        }catch (Exception e){
            e.printStackTrace();
            throw  RestException.restThrow("BIR YILDA BIR XIL NOMLI 2 TA JOURNAL OCHISH MUMKINMAS VA BIR GURUHGA BIR YILDA 2 TA JURNAL TUTISH MUMKINMAS YOKI GURUG MAVJUDMAS",HttpStatus.CONFLICT);

        }
    }

    @Override
    public ApiResult<?> getOne(Integer id) {
        Journal journal = baseService.getJournalOrElseThrowById(id);
        List<SubjectResDto> subjectResDtoList =
                subjectRepository.findAllByGroupId(journal.getGroup1().getId())
                .stream().map(SubjectResDto::new).collect(Collectors.toList());
        return ApiResult.successResponse(new JournalResDto(journal,subjectResDtoList));
    }

    @Override
    public ApiResult<?> getAll() {
        List<Journal> journalList = journalRepository.findAll();
        List<JournalAllResDto> journalsDto = journalList.stream().map(JournalAllResDto::new).collect(Collectors.toList());

        return ApiResult.successResponse(journalsDto);
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        try {
            journalRepository.deleteById(id);
            return ApiResult.successResponse("SUCCESS DELETED JOURNAL");
        }catch (Exception e){
            e.printStackTrace();
            throw RestException.restThrow("BU JOURNALNI O'CHIRA OLMAYSIZ YOKI JOURNAL TOPILMADI",HttpStatus.CONFLICT);
        }
    }
}
