package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Subject;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectResDto {

    private Integer id;

    private String name;

    public SubjectResDto(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
    }
}
