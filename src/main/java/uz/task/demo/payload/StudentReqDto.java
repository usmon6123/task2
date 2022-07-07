package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Group1;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentReqDto {

    @NotBlank(message = "nom bo'sh bo'lmasin")
    private String name;

    @NotNull(message = "talaba guruhini kiriting")
    private Integer groupId;
}
