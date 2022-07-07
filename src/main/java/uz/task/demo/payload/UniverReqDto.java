package uz.task.demo.payload;

import lombok.*;
import uz.task.demo.entity.University;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class UniverReqDto {

    private String name;
    private String address;
    private Integer openYear;

}
