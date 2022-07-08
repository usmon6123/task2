package uz.task.demo.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.task.demo.entity.*;
import uz.task.demo.repository.*;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UniversityRepository universityRepository;
    private final FacultyRepository facultyRepository;
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final JournalRepository journalRepository;
    private final SubjectRepository subjectRepository;

    @Value("${dataLoaderMode}")
    private String dataLoaderMode;

    @Override
    public void run(String... args) throws Exception {
        if (dataLoaderMode.equals("always")) {
            University tatu = universityRepository.save(new University("TATU", "\tAmir Temur koʻchasi 108, Toshkent shahri, 100020, Oʻzbekiston", 1955));

            ArrayList<Faculty> faculties = new ArrayList<>();
            Faculty mobilTizim = new Faculty("Mobil tizim", tatu);
            faculties.add(mobilTizim);
            faculties.add(new Faculty("Radio aloqa", tatu));
            faculties.add(new Faculty("Dastur injenering", tatu));
            faculties.add(new Faculty("Kompyuter injenering", tatu));
            facultyRepository.saveAll(faculties);

            ArrayList<Group1> groups = new ArrayList<>();
            Group1 group830 = new Group1("830-19", mobilTizim, 2019);
            groups.add(group830);
            groups.add(new Group1("831-19",mobilTizim,2019));
            groups.add(new Group1("833-19",mobilTizim,2019));
            groups.add(new Group1("850-19",mobilTizim,2019));
            groupRepository.saveAll(groups);

            ArrayList<Student> students = new ArrayList<>();
            Student bekzod = new Student("Bekzod", group830);
            students.add(bekzod);
            students.add(new Student("Shaxzod",group830));
            students.add(new Student("Azamat",group830));
            students.add(new Student("Nozimbek",group830));
            students.add(new Student("Usmon",group830));
            students.add(new Student("Abduhalil",group830));
            students.add(new Student("Boburbek",group830));
            students.add(new Student("Yo'ldosh",group830));
            students.add(new Student("Davron",group830));
            students.add(new Student("Jahongir",group830));
            studentRepository.saveAll(students);

            ArrayList<Subject> subjects = new ArrayList<>();
            subjects.add(new Subject("Dasturlash"));
            subjects.add(new Subject("Malumotlar ombori"));
            subjects.add(new Subject("O'rnatilgan Tizimlar"));
            subjects.add(new Subject("Chiziqli Algebra"));
            subjects.add(new Subject("Tarmoq Xavfsizligi"));
            subjects.add(new Subject("Simsiz Aloqa"));
            subjects.add(new Subject("Infokomunikatsiya"));
            subjects.add(new Subject("Operatsion Tizimlar"));
            subjects.add(new Subject("Differensial Tenglamalar"));
            subjectRepository.saveAll(subjects);

            ArrayList<Journal> journals = new ArrayList<>();
            journals.add(new Journal("Jurnal 830-19 2022",group830,2022));
            journalRepository.saveAll(journals);
        }
    }
}
