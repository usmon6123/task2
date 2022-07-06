package uz.task.demo.entity;

import lombok.*;
import uz.task.demo.entity.template.AbsIntegerEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class Student extends AbsIntegerEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group1 group1;

}
