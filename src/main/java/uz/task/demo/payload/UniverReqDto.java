package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.task.demo.entity.University;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniverReqDto {

    private String name;
    private String address;
    private Integer openYear;

}
