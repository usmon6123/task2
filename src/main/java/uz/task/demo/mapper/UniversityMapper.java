package uz.task.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.task.demo.entity.University;
import uz.task.demo.payload.UniverReqDto;
import uz.task.demo.payload.UniverResDto;

@Mapper(componentModel = "spring")
public interface UniversityMapper {

    //DTO DAGI MA'LUMOTLAR ORQALI UNIVERSITY YASABERADI
    @Mapping(target = "id",ignore = true)
    University dtoToUniversity(UniverReqDto univerReqDto);

    //UNIVERSITY DAGI MA'LUMOTLARNI DTOGA O'GIRIBERADI
    UniverResDto universityToDto(University university);


    //DTODAGI MALUMOTLARNI UNIVERSITYGA SET QILADI
    void updateUniversityWithDto(@MappingTarget University university,UniverReqDto univerReqDto);


}
