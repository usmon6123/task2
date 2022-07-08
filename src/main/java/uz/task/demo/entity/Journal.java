package uz.task.demo.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import uz.task.demo.entity.template.AbsIntegerEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor@NoArgsConstructor@Getter@Setter
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name", "year"}),
        @UniqueConstraint(columnNames = {"group1_id", "year"})
})
public class Journal extends AbsIntegerEntity {

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group1 group1;

    //jurnal tutilgan yil(guruhlarga har o'quv yilida yangisi tutiladi)
    private int year;

}
