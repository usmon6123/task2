package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniverResDto {

    private Integer id;
    private String name;
    private String address;
    private int openYear;

}
