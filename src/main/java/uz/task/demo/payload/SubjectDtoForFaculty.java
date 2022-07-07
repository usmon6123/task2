package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectDtoForFaculty {
   private Integer facultyId;
   private List<SubjectDtoForGroup> subjectsGroupList;

}
