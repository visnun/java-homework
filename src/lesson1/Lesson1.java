package lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        // Задача на тернарный оператор
        long start = 50, end = 10;
        long between = start < end ? end - start : -1;
        System.out.println(between);

        // Найти сумму цифр двухзначного числа
        int number = 37;
        int firstDigit = number / 10;
        int secondDigit = number % 10;
        int result = firstDigit + secondDigit;
        System.out.println(result);

        // Найти сумму цифр трехзначного числа
        number = 471;
        firstDigit = number / 100;
        number %= 100;
        secondDigit = number / 10;
        int thirdDigit = number % 10;
        result = firstDigit + secondDigit + thirdDigit;
        System.out.println(result);
    }
}

