package lesson2;

import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) {
        /*
        1. Задача на if
        Дана целочисленная переменная count - количество верных ответов.
        В зависимости от значения этой переменной вывести в консоль оценку:
        100 - 90 правильных ответов - отлично
        89 - 60 правильных ответов - хорошо
        59 - 40 правильных ответов - удовлетворительно
        39 - 0 правильных ответов - попробуйте в следующий раз
         */
        int count = 95;
        if (count < 0 || count > 100) {
            System.out.println("Значение переменной count долно быть в диапазоне 0;100");
        }
        if (count <= 100 && count >= 90) {
            System.out.println("Отлично");
        }
        if (count <= 89 && count >= 60) {
            System.out.println("Хорошо");
        }
        if (count <= 59 && count >= 40) {
            System.out.println("Удовлетворительно");
        }
        if (count <= 39 && count >= 0) {
            System.out.println("Попробуйте в следующий раз");
        }

        /*
        2. Задача на switch
        Пользователь вводит 3 числа:
        1е - первый операнд
        2e - второй операнд
        3е - оператор
        В зависимости от третьего введенного числа нужно вывести в консоль:
        сумму, разность, умножение, деления чисел, которые ввел пользователь.
        Если 3е введенное число 3, нужно найти сумму,
        если 5 - разность,
        если 7 - результат умножения,
        если 9 - результат деления.
         */
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первый операнд:");
        int firstOperand = in.nextInt();
        System.out.println("Введите второй операнд:"); // TODO проверка на 0
        int secondOperand = in.nextInt();
        System.out.println("Введите оператор:");
        int operator = in.nextInt();
        switch (operator) {
            case 3 -> System.out.println(firstOperand + secondOperand);
            case 5 -> System.out.println(firstOperand - secondOperand);
            case 7 -> System.out.println(firstOperand * secondOperand);
            case 9 -> System.out.println((double) firstOperand / secondOperand);
            default -> System.out.println("Значение оператора должно быть одним из: 3, 5, 7 или 9");
        }

        /*
        3. Задача на цикл while
        Считать с консоли количество тарелок и количество моющего средства
        Моющее средство расходуется из расчета 0.5 на 1 тарелку
        В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
        В конце вывести сколько тарелок осталось, когда моющее средство закончилось или
        наоборот.
         */
        System.out.println("Введите кол-во тарелок"); // TODO проверка на 0
        int platesQty = in.nextInt();
        System.out.println("Введите кол-во моющего средства"); // TODO проверка на 0
        double cleaningAgentAmount = in.nextDouble();
        while (platesQty > 0 && cleaningAgentAmount > 0) {
            platesQty -= 1;
            cleaningAgentAmount -= 0.5;
            System.out.println("Осталось тарелок: " + platesQty);
            System.out.println("Осталось мобщего средства: " + cleaningAgentAmount);
        }
        if (platesQty == 0) {
            System.out.println("Осталось моющего средства: " + cleaningAgentAmount);
        } else {
            System.out.println("Осталось тарелок: " + platesQty);
        }

        /*
        4. Программа загадывает число в диапазоне [1;9]
        Пользователь вводит число с клавиатуры
        Программа в зависимости от введенного числа выводит в консоль следующее:
        "загаданное число больше"
        "загаданное число меньше"
        "Вы угадали" (программа завершает работу)
        если введен 0, выводит "выход из программы" (программа завершает работу)
         */
        int answer = 7;
        while (true) {
            System.out.println("Введите число:");
            int number = in.nextInt();
            if (number == 0) {
                System.out.println("Выход из программы");
                break;
            }
            if (number == answer) {
                System.out.println("Вы угадали!");
                break;
            }
            if (number > answer) {
                System.out.println("Загаданное число меньше");
            }
            if (number < answer) {
                System.out.println("Загаданное число больше");
            }
        }

        /*
        5. Задача на Math.random() и if
        Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500]
        в интервал (25;200) и выводить результат в консоль.
        Примеры работы программы:
        Число 345 не содержится в интервале (25;200)
        Число 110 содержится в интервале (25;200)
         */
        int number = (int) (Math.random() * 491) + 10;
        if (number > 25 && number < 200) {
            System.out.println("Число " + number + " содержится в интервале (25;200)");
        } else {
            System.out.println("Число " + number + " не содержится в интервале (25;200)");
        }

        /*
        6. Пользователь!!! загадывает число в диапазоне от [1 до 100]
        Программа пытается его угадать (используйте метод !!!бинарного поиска - деление отрезка на 2).
        Программа может задавать пользователю вопросы:
        Число равно ...? / Число больше ...? / Число меньше ...?
        и в зависимости от ответа пользователя принимать решения.
        !!! Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
         */

    }
}