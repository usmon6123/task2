package uz.task.demo.entity;

import lombok.*;
import uz.task.demo.entity.template.AbsIntegerEntity;

import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class University extends AbsIntegerEntity {

    private String name;
    private String address;
    private int openYear;
}
