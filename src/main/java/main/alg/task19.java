package main.alg;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class task19 {
    public static HashMap<String, String> solve() {
        // Инициализация переменных
        HashMap<String, String> result = new HashMap<String, String>();
        Random random = new Random();
        int[] dims = new int[] { ThreadLocalRandom.current().nextInt(2, 10),
                ThreadLocalRandom.current().nextInt(2, 10) };
        int[][] dim2_arr;

        // Создание и заполнение исходной матрицы
        dim2_arr = new int[dims[0]][dims[1]];
        fill_2dim_array(dim2_arr, random);

        // Добавление в результирующий словарь исходной матрицы и её размера
        result.put("matr", dim2_arr_printer(dim2_arr));
        result.put("size", String.valueOf(dims[0]) + " на " + String.valueOf(dims[1]));

        // Вычисление суммы значений элементов главной или побочной диагонали
        // и вывод результата
        if (dims[0] == dims[1]) {
            int sum[] = diagonal_sum(dim2_arr);

            result.put("main", String.valueOf(sum[0]));
            result.put("secondary", String.valueOf(sum[0]));

        } else {
            // Матрица не квадратная
            result.put("main", "");
            result.put("secondary", "");
        }

        return result;
    }

    // Заполнение матрицы случайными значениями
    static int[][] fill_2dim_array(int[][] arr, Random random) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(5);
            }
        }
        return arr;
    }

    // Форматирование матрицы в надлежащий для вывода вид
    static String dim2_arr_printer(int[][] dim2_arr) {
        String res = "";

        for (int i = 0; i < dim2_arr.length; i++) {
            for (int j = 0; j < dim2_arr[i].length; j++) {
                if (j == 0 && i > 0) {
                    res += "\n";
                }
                res = res + dim2_arr[i][j] + " ";
            }
        }

        return res;
    }

    // Вычисление суммы элементов по диагоналям
    public static int[] diagonal_sum(int[][] arr) {
        int[] res = new int[2];
        int sum = 0;

        // Сумма элементов главной диагонали
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        res[0] = sum;

        sum = 0;

        return res;
    }
}
