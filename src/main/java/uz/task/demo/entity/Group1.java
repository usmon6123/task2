package uz.task.demo.entity;

import lombok.*;
import uz.task.demo.entity.template.AbsIntegerEntity;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Subject> subjectList;

    private Boolean active = true;

    public Group1(String name, Faculty faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }
}
