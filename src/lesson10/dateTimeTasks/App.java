package lesson10.dateTimeTasks;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class App {
    public static void main(String[] args) {
        /*
        Задача 1
        Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.
        Самолет вылетает из Сиднея (дата любая, например 16 июня 2020) в 19:00 (время местное для Сиднея).

        Время в пути Сидней -  Хьюстон - 15 часов 35 минут
        Время ожидания в аэропорту Хьюстона - 1 час
        Время в пути  Хьюстон - Вашингтон - 2 часа 49 минут
        Время ожидания в аэропорту Вашингтона - 1 час 10 минут
        Время в пути Вашингтон - Оттава - 1 час 40 минут

        Вывести в консоль:
        Время прибытия! в аэропорт Оттавы (время местное для Оттавы)
        Время вылета! из аэропорта Хьюстона (время местное для Хьюстона)
        Время вылета! из аэропорта Вашингтона (время местное для Вашингтона)

        Часовые пояса:
        Сидней - Australia/Sydney
        Хьюстон - America/Chicago
        Вашингтон - America/New_York
        Оттава - America/Toronto
        */
        LocalDateTime departure = LocalDateTime.of(2020, Month.JUNE, 16, 19, 0);
        System.out.println(departure.getHour());
        LocalDateTime departureFromHouston = departure.plusHours(3).plusMinutes(49);
        System.out.println(departureFromHouston);

        /*
        Задача 2
        Есть три рабочие смены :
        с 7:00 до 15:00 утренняя
        с 15:00 до 23:00 дневная
        с 23:00 до 7:00 ночная
        Определить, какая сейчас смена (относительно текущего времени)
        */
        LocalTime currentTime = LocalTime.of(2, 0);

        if (currentTime.isAfter(LocalTime.of(7, 0))
                && currentTime.isBefore(LocalTime.of(15, 0))) {
            System.out.println("Утренняя");
        } else if (currentTime.isAfter(LocalTime.of(15, 0))
                && currentTime.isBefore(LocalTime.of(23, 0))) {
            System.out.println("Дневная");
        } else {
            System.out.println("Ночная");
        }
        /*
        Задача 3
        Допустим, наше последнее занятие состоится 16 июня 2021 года.
        Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт)?
        Когда состоится защита диплома, если на подготовку дается 2 недели?
         */
    }
}
