package uz.task.demo.entity;

import lombok.*;
import uz.task.demo.entity.template.AbsIntegerEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mark extends AbsIntegerEntity {

/* BU ENTITY TALABANING FAN BO'YICHA OLGAN YAKUNIY BAHOSINI
   JURNALGA TUSHIRISH UCHUN */

    private double mark;

    @JoinColumn(insertable = false, updatable = false, name = "group_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @JoinColumn(insertable = false, updatable = false, name = "group_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @Column(nullable = false, name = "student_id")
    private int studentId;
//---------------------------------------------------------------------

}
