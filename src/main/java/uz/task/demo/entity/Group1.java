package uz.task.demo.entity;

import lombok.*;
import uz.task.demo.entity.template.AbsIntegerEntity;

import javax.persistence.*;

//GROUP DEB NOMLANGANDA SQL EXSEPTION TASHLASHI MUMKINLIGIDAN GROUP1 GA O'ZGARTIRILDI
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class Group1 extends AbsIntegerEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;

    //GURUH OCHILGAN YIL
    private int year;
}
