package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Faculty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FacultyResDto {

    private Integer id;

    private String name;

    private Integer universityId;

    public FacultyResDto(Faculty faculty) {
        this.id = faculty.getId();
        this.name = faculty.getName();
        this.universityId = faculty.getUniversity().getId();
    }
}
