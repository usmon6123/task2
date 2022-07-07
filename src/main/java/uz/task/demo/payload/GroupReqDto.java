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
public class GroupReqDto {

    @NotBlank(message = "nom bo'sh bo'lmasin")
    private String name;

    @NotNull()
    private Integer facultyId;

    private int year;

    private Boolean active = true;
}
