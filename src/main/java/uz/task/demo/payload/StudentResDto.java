package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Student;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResDto {

    private Integer id;

    private String name;

    private Integer groupId;

    public StudentResDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.groupId = student.getGroup1().getId();
    }
}
