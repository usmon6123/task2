package uz.task.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.task.demo.entity.University;
import uz.task.demo.exception.RestException;
import uz.task.demo.mapper.UniversityMapper;
import uz.task.demo.payload.ApiResult;
import uz.task.demo.payload.UniverReqDto;
import uz.task.demo.payload.UniverResDto;
import uz.task.demo.repository.UniversityRepository;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;
    private final UniversityMapper universityMapper;

    @Override
    public ApiResult<UniverResDto> add(UniverReqDto univerReqDto) {

        //UNIVERSITED NOMINING UNIQUELIGINI TEKSHIRYAPMIZ AKS HOLDA THROW
        existsName(univerReqDto.getName());

        //DTO DAGI MA'LUMOTLAR ORQALI UNIVERSITY YASABERADI
        University university = universityMapper.dtoToUniversity(univerReqDto);

        //BAZAGA SAQLAYAPDI UNIVERSITEDNI
        universityRepository.save(university);

        //UNIVERSITY DAGI MA'LUMOTLARNI DTOGA O'GIRIB QAYTARYAPDI
        UniverResDto univerResDto = universityMapper.universityToDto(university);
        return ApiResult.successResponse(univerResDto);

    }

    @Override
    public ApiResult<UniverResDto> getOne(Integer id) {

        //ID ORQALI UNIVERSITEDNI BAZADAN OLIBERADI TOPOLMASA THROW
        University university = getUniversityElseThrowById(id);

        //UNIVERSITY DAGI MA'LUMOTLARNI DTOGA O'GIRIB QAYTARYAPDI
        return ApiResult.successResponse(universityMapper.universityToDto(university));
    }


    @Override
    public ApiResult<?> edit(Integer id, UniverReqDto univerReqDto) {

        //UNIVERSITED NOMINING UNIQUELIGINI TEKSHIRYAPMIZ AKS HOLDA THROW
        existsName(id, univerReqDto.getName());

        //ID ORQALI UNIVERSITEDNI BAZADAN OLIBERADI TOPOLMASA THROW
        University university = getUniversityElseThrowById(id);

        //DTODAGI MALUMOTLARNI UNIVERSITYGA SET QILYAPDI
        universityMapper.updateUniversityWithDto(university, univerReqDto);

        //O'ZGARTIRISHLARNI BAZAGA SAQLAYAPDI
        universityRepository.save(university);

        return ApiResult.successResponse(univerReqDto,"SUCCESS EDITED id: "+id);
    }

    @Override
    public ApiResult<?> delete(Integer id) {

        //ID ORQALI UNIVERSITEDNI BAZADAN QIDIRADI TOPOLMASA THROW
        existsOrElseThrowById(id);

        //ICHIDA FAKULTEDI BOR UNIVER BO'LSA THROWGA OTAMIZ
        if (universityRepository.existsUniverFaculty(id))
            throw RestException.restThrow("BU UNIVERSITEDNI O'CHIRA OLMAYSIZ FAKULTEDLAR BOR", HttpStatus.CONFLICT);

        //BAZADAN O'CHIRIB TASHLAYAPDI
        universityRepository.deleteById(id);

        return ApiResult.successResponse("DELETED SUCCESS");
    }


//-----------------------Yordamchi methodlar---------------------------

    //ID ORQALI UNIVERSITEDNI BAZADAN OLIBERADI TOPOLMASA THROW
    private University getUniversityElseThrowById(Integer id) {
        return universityRepository.findById(id).orElseThrow(() -> RestException.notFound("UNIVERSITY NOT FOUND"));
    }

    //ID ORQALI UNIVERSITEDNI BAZADAN QIDIRADI TOPOLMASA THROW
    private void existsOrElseThrowById(Integer id) {
        if (!universityRepository.existsById(id))
            throw RestException.notFound("UNIVERSITY NOT FOUND");
    }

    //UNIVERSITED NOMINING UNIQUELIGINI TEKSHIRYAPMIZ AKS HOLDA THROW
    private void existsName(String name) {
        if (universityRepository.existsByName(name))
            throw RestException.alreadyExists("UNIVERSITY ALREADY EXIST");
    }

    //UNIVERSITED NOMINING UNIQUELIGINI TEKSHIRYAPMIZ AKS HOLDA THROW
    private void existsName(Integer id, String name) {
        if (universityRepository.uniqueByName(id, name))
            throw RestException.alreadyExists("UPDATE UNIVERSITY NAME ALREADY EXIST");
    }

}
