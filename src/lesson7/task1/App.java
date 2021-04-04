package lesson7.task1;

public class App {
    public static void main(String[] args) {
        Pupil pupil1 = new Pupil("Василий Рогов", 12, "Математика");
        Pupil pupil2 = new Pupil("Семен Иванов", 14, "Английский язык");
        Pupil pupil3 = new Pupil("Артем Александров", 9, "Математика");
        Pupil pupil4 = new Pupil("Анастасия Еремова", 10, "Английский язык");

        Teacher teacher1 = new Teacher("Ольга Ивановна Константинова", 35, "Математика");
        Teacher teacher2 = new Teacher("Николай Владимирович Пак", 55, "Английский язык");

        Principal principal = new Principal("Виктор Николаевич Шонин", 45);

        School school = new School("Школа № 596");
        school.addPrincipal(principal);
        school.addTeacher(teacher1);
        school.addTeacher(teacher2);
        school.addPupil(pupil1);
        school.addPupil(pupil2);
        school.addPupil(pupil3);
        school.addPupil(pupil4);
        school.dayAtSchool();
        System.out.println(school);
    }
}
