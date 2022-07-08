package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Group1;
import uz.task.demo.entity.Subject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupResDto {

    private Integer id;

    private String name;

    private Integer facultyId;

    private int year;

    private Boolean active = true;

    private List<SubjectResDto> subjectList;

    public GroupResDto(Group1 group) {
        this.id = group.getId();
        this.name = group.getName();
        this.facultyId = group.getFaculty().getId();
        this.year = group.getYear();
        this.active = group.getActive();
        this.subjectList = group.getSubjectList().stream().map(SubjectResDto::new).collect(Collectors.toList());
    }
}
