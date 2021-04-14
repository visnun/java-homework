package exams.first;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Имя1", "Фамилия1", LocalDate.of(1984, Month.JUNE, 15));
        Membership membership1 = new Membership("Разовый", owner1);
        FitnessClub fitnessClub = new FitnessClub();
        fitnessClub.register(membership1, "Тренажерный зал");
    }
}
