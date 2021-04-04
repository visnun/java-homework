package lesson7.task1;

import java.util.Arrays;
import java.util.Objects;

public class School {
    /*
    Класс Школа
        создается со следующими харатеристиками:
            название - задается при создании объекта и не может быть изменено в последствии
            директор - школа не может функционировать без директора
            учителя[] - массив
            ученики[] - массив
        и методом:
            день в школе() -
                1. директор объявляет начало занятий
                2. учителя учат учеников (предмет учителя и ученика должны совпадать)
                3. директор объявляет окончание занятий
     */

    private String name;
    private Principal principal;
    private final Teacher[] teachers;
    private final Pupil[] pupils;


    public School(String name) {
        setName(name);
        teachers = new Teacher[10];
        pupils = new Pupil[20];
    }

    public String getName() {
        return name;
    }

    private void setName (String name) {
        if (name == null || name.length() < 1) throw new IllegalArgumentException("Некорректное название");
    }

    public Principal getPrincipal() {
        return principal;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public Pupil[] getPupils() {
        return pupils;
    }

    public void addPrincipal (Principal principal) {
        Objects.requireNonNull(principal, "Директор не может быть null");
        this.principal = principal;
    }

    public void addTeacher(Teacher teacher) {
        Objects.requireNonNull(teacher, "Учитель не может быть null");
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                return;
            };
        }
    }

    public void addPupil(Pupil pupil) {
        Objects.requireNonNull(pupil, "Ученик не может быть null");
        for (int i = 0; i < pupils.length; i++) {
            if (pupils[i] == null) {
                pupils[i] = pupil;
                return;
            };
        }
    }

    public void dayAtSchool() {
        if (principal == null) {
            System.out.println("Школа не может функционировать без директора");
            return;
        };
        principal.startLessonsAnnouncement();
        for (int i = 0; i < teachers.length & teachers[i] != null; i++) {
            for (int j = 0; j < pupils.length & pupils[j] != null; j++) {
                if (teachers[i].getTeaching().equalsIgnoreCase(pupils[j].getLearning())) teachers[i].teach(pupils[j]);
            }
        }
        principal.endLessonsAnnouncement();
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", principal=" + principal +
                ", teachers=" + Arrays.toString(teachers) +
                ", pupils=" + Arrays.toString(pupils) +
                '}';
    }
}
