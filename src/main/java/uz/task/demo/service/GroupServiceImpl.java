package uz.task.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.task.demo.entity.Faculty;
import uz.task.demo.entity.Group1;
import uz.task.demo.entity.University;
import uz.task.demo.exception.RestException;
import uz.task.demo.mapper.UniversityMapper;
import uz.task.demo.payload.*;
import uz.task.demo.repository.GroupRepository;
import uz.task.demo.repository.UniversityRepository;
import uz.task.demo.service.basic.BaseService;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final BaseService baseService;

    @Override
    public ApiResult<?> add(GroupReqDto groupReqDto) {

        //ID ORQALI FAKULTEDNI BAZADAN OLIBERADI TOPOLMASA THROW
        Faculty faculty = baseService.getFacultyOrElseThrowById(groupReqDto.getFacultyId());

        //BIR O'QUV YILIDA IKKITA BIR XIL NOMLI GURUH OCHAMAN DESA THROWGA OTADI
        existsGroup(groupReqDto.getName(), groupReqDto.getYear());

        //GURUHNI BAZAGA SAQLAYAPMIZ
        Group1 saveGroup = groupRepository.save(new Group1(groupReqDto.getName(), faculty, groupReqDto.getYear(), groupReqDto.getActive()));

        return ApiResult.successResponse(new GroupResDto(saveGroup),"SUCCESS ADDED GROUP");

    }

    @Override
    public ApiResult<?> getOne(Integer id) {

        //ID VA ACTIVE TRUE ORQALI GROUPNI BAZADAN OLIBERADI TOPOLMASA THROW
        Group1 group = baseService.getGroupOrElseThrowById(id);

        return ApiResult.successResponse(new GroupResDto(group));
    }

    @Override
    public ApiResult<CustomPage<?>> getAllByFaculty(Integer facultyId, int page, int size) {
        return null;
    }

    @Override
    public ApiResult<CustomPage<?>> getAllByUniverInYear(Integer facultyId, int openYear, int page, int size) {
        return null;
    }

    //todo vaqt yetsa yozamiz Inshaalloh
    @Override
    public ApiResult<?> edit(Integer id, GroupReqDto groupReqDto) {
        return ApiResult.successResponse("vaqt yetsa yozamiz Inshaalloh");
    }

    @Override
    public ApiResult<?> delete(Integer id) {

        //O'CHIRISHGA MONE HOLATLAR BO'LSA THROW
        if (groupRepository.exists(id)) throw RestException.restThrow("BU GRUHNI O'CHIRA OLMAYSIZ",HttpStatus.CONFLICT);

        groupRepository.deleteById(id);
        return ApiResult.successResponse("SUCCESS DELETED GROUP");
    }


//    ---------------HELPER METHOD---------------

private void existsGroup(String name,int year){
    boolean exists = groupRepository.existsByNameAndYearAndActiveTrue(name,year);
    if (exists)throw RestException.alreadyExists("BU YIL BUNDAY NOMLI GURUH OCHILGAN");

}
}
