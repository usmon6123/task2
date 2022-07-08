package uz.task.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.task.demo.entity.Journal;

import javax.security.auth.Subject;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JournalResDto {

    private Integer id;

    private String name;

    private Integer groupId;

    private int year;

    private List<SubjectResDto> subjectResDtoList;

    public JournalResDto(Journal journal,List<SubjectResDto> subjectResDtoList) {
        this.id = journal.getId();
        this.name = journal.getName();
        this.groupId = journal.getGroup1().getId();
        this.year = journal.getYear();
        this.subjectResDtoList = subjectResDtoList;
    }

    public JournalResDto(Integer id, String name, Integer groupId, int year) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
        this.year = year;
    }
}
