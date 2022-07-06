package uz.task.demo.entity;

import lombok.*;
import uz.task.demo.entity.template.AbsIntegerEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
public class Journal extends AbsIntegerEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group1 group1;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Subject> subjects;

}
