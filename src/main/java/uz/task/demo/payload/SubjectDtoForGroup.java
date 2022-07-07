package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Subject;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectDtoForGroup {

    private Integer groupId;

    private List<SubjectResDto> subjectList;
}
