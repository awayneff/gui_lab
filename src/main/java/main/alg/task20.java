package main.alg;

import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class task20 {

    public static void main(String[] args) {
        // Инициализация переменных
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr_list = new ArrayList<Integer>();
        String[] arr;

        // Заполнение массива-списка и создание массива для двоичных чисел
        arr_input(scanner, arr_list);
        arr = new String[arr_list.size()];

        // Вывод исходного массива-списка
        System.out.println("\n\nИсходный список элементов.");
        System.out.println(arr_list.toString().substring(1, arr_list.toString().length() - 1));

        // Перевод каждого элемента из десятичной в двоичную систему
        // Вывод полученных элементов на экран
        System.out.println("\nПолученный список элементов в двоичной системе.");

        String sep = ", ";
        for (int i = 0; i < arr_list.size(); i++) {
            if (i == arr_list.size() - 1)
                sep = "";

            arr[i] = dec_to_bin(arr_list.get(i));

            System.out.print(arr[i] + sep);
        }

        System.out.println("\n\n\nПрограмма завершена.\n");
    }

    public static String dec_to_bin(int num) {
        String res = "";

        while (num >= 1) {
            res += String.valueOf(num % 2);
            num /= 2;
        }

        res = new StringBuilder(res).reverse().toString();

        return res;
    }

    static ArrayList<Integer> arr_input(Scanner scanner, ArrayList<Integer> arr) {
        String inp;
        Integer int_inp = null;

        while (true) {
            System.out.println("\nВведите число.");
            inp = scanner.nextLine();

            try {
                int_inp = Integer.parseInt(inp);

                if (int_inp == 0)
                    break;
                else {
                    arr.add(int_inp);
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода. Пожалуйста, попробуйте ещё раз.");
            }
        }

        return arr;
    }
}
