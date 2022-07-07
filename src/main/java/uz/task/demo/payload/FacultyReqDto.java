package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.University;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FacultyReqDto {

    @NotBlank(message = "faculted nomi bo'sh bo'lmasin")
    private String name;

    @NotNull(message = "Univer idsini facultedga biriktirishni unutdingiz")
    private Integer universityId;


}
