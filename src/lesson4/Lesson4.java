package lesson4;

import java.util.Arrays;

public class Lesson4 {
    public static void main(String[] args) {
        // 1. Создать одномерный массив типа int на 20 элементов. Заполнить его рандомными значениями от 3 до 500.
        // Поменять местами минимальный и максимальный элементы.
        System.out.println("Задача №1");
        int[] ints = new int[20];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, indexOfMin = 0, indexOfMax = 0, someVal;

        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 498 + 3);
            if (min > ints[i]) {
                min = ints[i];
                indexOfMin = i;
            }
            if (max < ints[i]) {
                max = ints[i];
                indexOfMax = i;
            }
        }
        System.out.println("Получившийся массив: " + Arrays.toString(ints));
        System.out.println("Минимальный элемент: " + min + ", " + "индекс элемента: " + indexOfMin);
        System.out.println("Максимальный элемент: " + max + ", " + "индекс элемента: " + indexOfMax);
        someVal = ints[indexOfMin];
        ints[indexOfMin] = ints[indexOfMax];
        ints[indexOfMax] = someVal;
        System.out.println("Итоговый массив: " + Arrays.toString(ints));


        // 2. Дан массив целых чисел [78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90].
        // Образуйте из него два отсортированных по возрастанию массива, содержащих четные и нечетные числа.
        System.out.println("");
        System.out.println("Задача №2");
        int[] ints1 = {78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90};
        int[] ints2 = new int[8];
        int[] ints3 = new int[3];
        int ints2Index = 0, ints3Index = 0;
        for (int i : ints1) {
            if (i % 2 == 0) {
                ints2[ints2Index] = i;
                ints2Index++;
            } else {
                ints3[ints3Index] = i;
                ints3Index++;
            }
        }
        Arrays.sort(ints2);
        Arrays.sort(ints3);
        System.out.println("Исходный массив: " + Arrays.toString(ints1));
        System.out.println("Отсортированный массив с четными числами: " + Arrays.toString(ints2));
        System.out.println("Отсортированный массив с нечетными числами: " + Arrays.toString(ints3));


        // 3. Дан массив целых чисел [-321, 894, -45, 782, -29, 12, -88]. Отрицательные элементы массива перенести в новый массив.
        // Размер массива должен быть равен количеству отрицательных элементов.
        System.out.println("");
        System.out.println("Задача №3");
        int[] ints4 = {-321, 894, -45, 782, -29, 12, -88};
        System.out.println("Исходный массив: " + Arrays.toString(ints4));
        int negativeNumCount = 0;
        for (int i : ints4) {
            if (i < 0) negativeNumCount++;
        }
        int[] ints5 = new int[negativeNumCount];
        int ints5Index = 0;
        for (int i : ints4) {
            if (i < 0) {
                ints5[ints5Index] = i;
                ints5Index++;
            }
        }
        System.out.println("Количество отрицательных элементов в исходном массиве: " + negativeNumCount);
        System.out.println("Новый массив с отрицательными элементами из исходного массива: " + Arrays.toString(ints5));
        System.out.println("Длина нового массива: " + ints5.length);

        // 4. Создать массив из чётных чисел [2, 4, 6, 8, 10, 12 ... 18, 20] и вывести элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)
        System.out.println("");
        System.out.println("Задача №4");
        int[] ints6 = new int[10];
        for (int i = 0, value = 2; i < ints6.length; i++, value += 2) {
            ints6[i] = value;
        }
        System.out.println("Получившийся массив: " + Arrays.toString(ints6));
        for (int i = ints6.length - 1; i >= 0; i--) {
            System.out.println("Индекс элемента: " + i + ", " + "значение элемента: " + ints6[i]);
        }

        // 5. Создать массив из 11 случайных целых чисел из отрезка [-1;1], вывести массив в консоль.
        // Определить какой элемент встречается в массиве чаще всего и вывести информацию об этом в консоль.
        System.out.println("");
        System.out.println("Задача №5");
        int[] ints7 = new int[11];
        int negOneCount = 0, nullCount = 0, oneCount = 0;
        for (int i = 0; i < ints7.length; i++) {
            ints7[i] = (int) Math.round((Math.random() * 2) - 1);
            if (ints7[i] < 0) negOneCount++;
            if (ints7[i] == 0) nullCount++;
            if (ints7[i] > 0) oneCount++;
        }
        System.out.println("Получившийся массив: " + Arrays.toString(ints7));
        if (negOneCount > nullCount && negOneCount > oneCount) System.out.println("Чаще всего встречается: -1");
        if (nullCount > negOneCount && nullCount > oneCount) System.out.println("Чаще всего встречается: 0");
        if (oneCount > nullCount && oneCount > negOneCount) System.out.println("Чаще всего встречается: 1");
    }
}
