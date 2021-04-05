package lesson5;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Lesson5 {
    public static void main(String[] args) {
        Scanner in;
        StringBuilder sb;
        String word, firstString, secondString;

        // 1. Задать массив на n слов.
        //В цикле считывать с консоли слова (scanner.nextLine()),
        //и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
        //В итоге в массиве будут только уникальные слова.
        //Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
        //Перед завершением программы, вывести получившийся массив в консоль
        //2. Найти количество вхождений одной строки в другую.
        //Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза
        //3. Написать функцию, которая проверяет, является ли строка палиндромом.
        //Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо,
        //так и справа налево.
        //Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром
        System.out.println("");
        System.out.println("Задача № 3");
        System.out.println("Проверка на палиндром.");
        in = new Scanner(System.in);
        sb = new StringBuilder();
        System.out.println("Введите строку:");
        String[] arrOfStrings = in.nextLine().strip().split(" ");
        for (String item : arrOfStrings) {
            sb.append(item);in = new Scanner(System.in);
        }
        firstString = sb.toString();
        System.out.println(firstString);
        secondString = sb.reverse().toString();
        System.out.println(secondString);
        System.out.println(firstString.equalsIgnoreCase(secondString) ? "Палиндром" : "Не палиндром");


        //4. Заменить все буквы в слове на строчные, а первую букву на заглавную
        //Например, дано hello, получаем Hello / дано HeLLO, получаем Hello
        //5. Вводится с клавиатуры массив слов. Определить, сколько слов начинается на определенную букву.
        System.out.println("");
        System.out.println("Зачада № 5");
        in = new Scanner(System.in);
        System.out.println("Введите массив строк");
        String[] arrOfWords = in.nextLine().split(" ");
        System.out.println("Введите букву для проверки");
        String letter = in.nextLine();
        int counter = 0;
        for (int i = 0; i < arrOfWords.length; i++) {
            System.out.println(arrOfWords[i]);
            if (arrOfWords[i].toLowerCase(Locale.ROOT).startsWith(letter)) counter++;
        }
        System.out.println(counter + " слов начинается на " + letter);
    }
}
