package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Student;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentIdName {

    private Integer id;
    private String name;

    public StudentIdName(Student student) {
        this.id = student.getId();
        this.name = student.getName();
    }
}
