package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Journal;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JournalAllResDto {

    private Integer id;

    private String name;

    private Integer groupId;

    private int year;

    public JournalAllResDto(Journal journal) {
        this.id = journal.getId();
        this.name = journal.getName();
        this.groupId = journal.getGroup1().getId();
        this.year = journal.getYear();
    }
}
