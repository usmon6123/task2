package uz.task.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.task.demo.entity.Subject;
import uz.task.demo.entity.University;
import uz.task.demo.exception.RestException;
import uz.task.demo.mapper.UniversityMapper;
import uz.task.demo.payload.*;
import uz.task.demo.repository.SubjectRepository;
import uz.task.demo.repository.UniversityRepository;
import uz.task.demo.service.basic.BaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final BaseService baseService;

    @Override
    public ApiResult<SubjectResDto> add(SubjectReqDto subjectReqDto) {

        //BAZADA SHU NOMLI FAN MAVJUD BO'LSA THROWGA OTAMIZ
        boolean exists = subjectRepository.existsByName(subjectReqDto.getName());
        if (exists) throw RestException.alreadyExists("THIS SUBJECT ALREADY EXISTS");

        Subject subject = subjectRepository.save(new Subject(subjectReqDto.getName()));

        return ApiResult.successResponse(new SubjectResDto(subject));
    }

    @Override
    public ApiResult<SubjectResDto> getOne(Integer id) {
        Subject subject = baseService.getSubjectOrElseThrowById(id);
        return ApiResult.successResponse(new SubjectResDto(subject));
    }

    @Override
    public ApiResult<SubjectDtoForGroup> getAllByGroupId(Integer groupId,int year) {

        //GURUHNING KIRITILGAN YILDAGI OTADIGAN FANLAR ROYHATI
        List<Subject> subjectList = subjectRepository.findAllByGroupId(groupId, year);

        //LISTNI DTOGA O'GIRIB QAYTARYAPMIZ
        return ApiResult.successResponse(new SubjectDtoForGroup(groupId,subjectsToDtos(subjectList)));
    }


    @Override
    public ApiResult<List<SubjectResDto>> getAll(Integer universityId) {
        List<Subject> subjectList = subjectRepository.findAll();

        return ApiResult.successResponse(subjectsToDtos(subjectList));
    }

    @Override
    public ApiResult<?> edit(Integer id, SubjectReqDto subjectReqDto) {

        //ID ORQALI SUBJECTNI BAZADAN OLIBERADI TOPOLMASA THROW
        Subject subject = baseService.getSubjectOrElseThrowById(id);

        //DTODAGI FIELDLARNI SUBJECTGA SET QILIB BAZAGA SAQLAYAPDI SUBJECTNI
        mapToSubjectAndSaveDb(subject,subjectReqDto);

        return ApiResult.successResponse(subjectReqDto,"SUCCES EDITED SUBJECT id :"+id);
    }

    @Override
    public ApiResult<?> delete(Integer id) {

        //O'CHIRMOQCHI BO'LGAN FAN BAZADA MAVJUD BO'LMASA THROWGA OTAMIZ
        if (!subjectRepository.existsById(id))throw RestException.notFound("O'CHIRMOQCHI BO'LGAN FAN BAZADA MAVJUDMAS");

        //BU FAN GURUHLARGA O'TILAYOTGAN BO'LSA THROWGA OTAMIZ
        if (subjectRepository.existsForDelete(id)) throw RestException.restThrow("BU FAN GURUHLARGA O'TILAYOTGANLIGI UCHUN O'CHIRA OLMAYSIZ",HttpStatus.CONFLICT);

        subjectRepository.deleteById(id);
        return ApiResult.successResponse("SUCCESS DELETED SUBJECT");
    }



//-----------------------Yordamchi methodlar---------------------------

    private List<SubjectResDto> subjectsToDtos(List<Subject> subjectList) {

        return subjectList.stream().map(SubjectResDto::new).collect(Collectors.toList());
    }

    private void mapToSubjectAndSaveDb(Subject subject, SubjectReqDto subjectReqDto){
        subject.setName(subjectReqDto.getName().isEmpty()?subject.getName():subjectReqDto.getName());
        subjectRepository.save(subject);
    }

}

