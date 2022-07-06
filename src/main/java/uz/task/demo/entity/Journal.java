package uz.task.demo.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Subject> subjects;

}
