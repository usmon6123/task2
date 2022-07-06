package uz.task.demo.entity;

import lombok.*;
import uz.task.demo.entity.template.AbsIntegerEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class Faculty extends AbsIntegerEntity {

    private String name;

    //BITTA UNIVERSITED HOLATI UCHUN OLIB KETYAPMAN
    @ManyToOne(fetch = FetchType.LAZY)
    private University university;

}
