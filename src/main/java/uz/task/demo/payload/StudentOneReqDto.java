package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentOneReqDto {

    @NotBlank(message = "nom bo'sh bo'lmasin")
    private String name;

    @NotNull(message = "talaba guruhini kiriting")
    private Integer groupId;
}
