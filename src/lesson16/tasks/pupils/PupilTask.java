package lesson16.tasks.pupils;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {

        // Используя Stream API:

        Pupil pupil1 = new Pupil("Сергей", Pupil.Gender.MALE, LocalDate.of(2008, Month.APRIL, 25));
        Pupil pupil2 = new Pupil("Ольга", Pupil.Gender.FEMALE, LocalDate.of(2005, Month.FEBRUARY, 15));
        Pupil pupil3 = new Pupil("Анастасия", Pupil.Gender.FEMALE, LocalDate.of(2006, Month.SEPTEMBER, 13));
        Pupil pupil4 = new Pupil("Олег", Pupil.Gender.MALE, LocalDate.of(2011, Month.MARCH, 6));
        Pupil pupil5 = new Pupil("Анастасия", Pupil.Gender.FEMALE, LocalDate.of(2006, Month.AUGUST, 20));
        Pupil pupil6 = new Pupil("Олег", Pupil.Gender.MALE, LocalDate.of(2008, Month.OCTOBER, 9));
        List<Pupil> pupils = new ArrayList<>();
        pupils.add(pupil1);
        pupils.add(pupil2);
        pupils.add(pupil3);
        pupils.add(pupil4);
        pupils.add(pupil5);
        pupils.add(pupil6);

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> byGender = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(byGender);

        // 2. Найти средний возраст учеников
        // double averageAge = pupils.stream().collect(Collectors.averagingDouble(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear()));
        double avgAge = pupils.stream()
                .mapToInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear())
                .average().orElse(0);
        System.out.println("Средний возраст " + avgAge);

        // 3. Найти самого младшего ученика
        // Optional<Pupil> youngest = pupils.stream().min(((o1, o2) -> o2.getBirth().compareTo(o1.getBirth())));
        Pupil yongest = pupils.stream().max(Comparator.comparing(Pupil::getBirth)).get();
        System.out.println("Младший - " + yongest);

        // 4. Найти самого взрослого ученика
        Optional<Pupil> oldest = pupils.stream().min(Comparator.comparing(Pupil::getBirth));
        System.out.println("Старший " + oldest.get());

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, List<Pupil>> byYearOfBirth = pupils.stream()
                .collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear()));
        System.out.println("По году рождения " + byYearOfBirth);

        // 6. Оставить учеников с неповторяющимися именами, имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]



        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        List<Pupil> sortedPupils = pupils.stream()
                .sorted(Comparator.comparing(Pupil::getGender)
                        .thenComparing(Pupil::getBirth)
                        .thenComparing(Pupil::getName).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Отсортированный список учеников " + sortedPupils);

         // 8. Вывести в консоль всех учеников в возрасте от N до M лет.
        pupils.stream().filter(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear() >= 11
                && LocalDate.now().getYear() - pupil.getBirth().getYear() <= 14).forEach(System.out::println);

        // 9. Собрать в список всех учеников с именем=someName
        List<Pupil> filteredByName = pupils.stream()
                .filter(pupil -> "Олег".equalsIgnoreCase(pupil.getName()))
                .collect(Collectors.toList());
        System.out.println("Список учеников с именем Олег - " + filteredByName);

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> genderAge = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.summingInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear())));
        System.out.println("Map<Пол, суммарный возраст> - " + genderAge);

    }
}