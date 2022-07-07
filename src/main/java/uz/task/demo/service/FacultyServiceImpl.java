package uz.task.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.task.demo.entity.Faculty;
import uz.task.demo.entity.University;
import uz.task.demo.exception.RestException;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.FacultyReqDto;
import uz.task.demo.payload.FacultyResDto;
import uz.task.demo.repository.FacultyRepository;
import uz.task.demo.service.basic.BaseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final BaseService baseService;

    @Override
    public ApiResult<?> add(FacultyReqDto facultyReqDto) {

        //ID ORQALI UNIVERSITEDNI BAZADAN OLIBERADI TOPOLMASA THROW
        University university = baseService.getUniversityOrElseThrowById(facultyReqDto.getUniversityId());

        //FACULTED NOMLARI UNIQUELIGINI TEKSHIRADI BAZADA MAVJUD BO'LSA THROW
        if (facultyRepository.existsByName(facultyReqDto.getName()))
            throw RestException.alreadyExists("FACULTY ALREADY EXIST");

        Faculty faculty = facultyRepository.save(new Faculty(facultyReqDto.getName(), university));

        return ApiResult.successResponse("SUCCESS ADED FACULTY id : " + faculty.getId());
    }

    @Override
    public ApiResult<?> getOne(Integer id) {

        //ID ORQALI FAKULTEDNI BAZADAN OLIBERADI TOPOLMASA THROW
        Faculty faculty = baseService.getFacultyOrElseThrowById(id);

        //FAKULTEDNING KERAKLI FIELDLARINI DTOGA O'RAB QAYTARYAPMIZ
        FacultyResDto result = new FacultyResDto(faculty);
        return ApiResult.successResponse(result);
    }

    @Override
    public ApiResult<?> getAll(Integer universityId) {
        List<Faculty> facultyList = facultyRepository.findAllByUniversity_Id(universityId);

        List<FacultyResDto> facultyResDtoList = facultyList.stream().map(FacultyResDto::new).collect(Collectors.toList());

        return ApiResult.successResponse(facultyResDtoList);
    }

    //todo vaqt yetsa yozamiz Inshaalloh
    @Override
    public ApiResult<?> edit(Integer id, FacultyReqDto facultyReqDto) {
        return ApiResult.successResponse("vaqt yetsa yozamiz Inshaalloh");
    }

    @Override
    public ApiResult<?> delete(Integer id) {

        if (!facultyRepository.existsById(id))
            throw RestException.notFound("O'CHIRMOQCHI BO'LGAN FACULTEDINGIZ BAZADA MAVJUDMAS");

        if (facultyRepository.isHavingGroup(id))
            throw RestException.restThrow("BU FACULTEDNI O'CHIRA OLMAYSIZ ICHIDA GURUHLAR BOR", HttpStatus.CONFLICT);

        facultyRepository.deleteById(id);
        return ApiResult.successResponse("SUCCESS DELETED FACULTY");
    }
}
