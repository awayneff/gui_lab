package main.alg;

import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;

public class task11 {

    public static HashMap<String, String> solve(int len) {
        // Инициализация переменных
        Random random = new Random();
        HashMap<String, String> result = new HashMap<>();

        int[] arr = new int[len];

        // Заполнение массива "случайными" числами
        fillArray(arr, len, random);

        // Сортировка массива по возрастанию
        int[] arr_sorted = arr.clone();
        Arrays.sort(arr_sorted);

        // Вычисление суммы цифр элементов отсортированного массива
        int[] sum_arr_sorted = new int[len];

        for (int i = 0; i < len; i++) {
            sum_arr_sorted[i] = number_counter(arr_sorted[i]);
        }

        // Вывод
        // Исходный массив
        result.put("source", printer(arr));

        // Отсортированный массив
        result.put("sorted", printer(arr_sorted));

        // Массив суммы цифр каждого числа отсортированного массива
        result.put("sum_arr", printer(sum_arr_sorted));

        return result;
    }

    // Генератор массива случайных чисел установленной длины
    static int[] fillArray(int[] arr, int n, Random random) {
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1200);
        }

        return arr;
    }

    // Форматирование массива для вывода
    public static String printer(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            String sep = ", ";

            if (i == array.length - 1) {
                sep = "";
            }

            result += Integer.toString(array[i]) + sep;
        }

        return result;
    }

    // Вычисление количества цифр в числе
    static int number_counter(int num) {
        int count = 0;

        if (num == 0) {
            return 1;
        }

        while (num > 0) {
            count += 1;
            num = num / 10;
        }

        return count;
    }
}
