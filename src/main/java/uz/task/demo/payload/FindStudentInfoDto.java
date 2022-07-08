package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FindStudentInfoDto {

    private Integer id;

    private String name;

    private Integer groupId;

    private String groupName;

    private Integer facultyId;

    private String facultyName;
}
