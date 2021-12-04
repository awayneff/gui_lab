package main.alg;

public class task21 {
    public static String solve() {
        String result = "";

        for (int i = -10; i < 11; i++) {
            result = result + "\t" + String.valueOf(i) + "\t\t" + func(i) + "\n";
        }

        return result;
    }

    static Integer func(int x) {
        Integer y = null;

        if (x < -5)
            y = 2 * Math.abs(x) - 1;
        if (-5 <= x && x <= 5)
            y = x ^ 2;
        if (x > 5)
            y = 2 * x;

        return y;
    }
}
