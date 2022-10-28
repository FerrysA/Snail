
import java.util.Random;
import java.util.Scanner;// библ для ввода с клавиатуры

public class Main {

    public static void Print(int[][] A) {
        int m = A[0].length;//длина
        int n = A.length;// высота

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " ");
            }

            System.out.println(" ");
        }
    }

    public static void Print(int[] A) {
        int m = A.length;//длина

        System.out.print("[");
        for (int i = 0; i < m; i++) {

            if (i != m - 1) {
                System.out.print(A[i] + " ");
            }
            if (i == m - 1) {
                System.out.print(A[i] + "");
            }

        }
        System.out.print("]");
    }
    public static int[][] createSpiral(int N) {

        int a[][] = new int[N][N];
        int i = 0;
        int j = 0;
        int n = 1;
        String s = "R";// R-Rigt, D-Down , L-Left, U-Up; Move:R-D-L-U

        while (n <= N * N) {

            if (s == "R") {
                for (; j < N && a[i][j] == 0 && n <= N * N; j++, n++) {

                    a[i][j] = n;
                }
                s = "D";
                j--;
                i++;
            }

            if (s == "D") {
                for (; i < N && a[i][j] == 0 && n <= N * N; i++, n++) {

                    a[i][j] = n;

                }
                s = "L";
                i--;
                j--;
            }

            if (s == "L") {
                for (; j >= 0 && a[i][j] == 0 && n <= N * N; j--, n++) {

                    a[i][j] = n;

                }
                s = "U";
                j++;
                i--;
            }

            if (s == "U") {
                for (; i >= 0 && a[i][j] == 0 && n <= N * N; i--, n++) {

                    a[i][j] = n;

                }
                s = "R";
                i++;
                j++;
            }
        }
        return a;
    }

    public static int[] snail(int[][] a) {


        int N = a.length;
        int l = 0;
        int r = N;
        int[] res = new int[N * N];
        int ri = 0;// res index

        int[] exs = {};// for 0x0

        int i = 0;
        int j = 0;
        if (a[0].length == 0) {
            return exs;
        }//if 0x0
        if (N == 1) {
            res[0] = a[0][0];
            return res;
        }

        while (ri < N * N) {
            for (; j < r - 1; j++, ri++) {// движ направо
                res[ri] = a[i][j];
                if (ri == N * N - 1) {
                    return res;
                }
            }
            for (; i < r - 1; i++, ri++)// движ вниз
            {
                res[ri] = a[i][j];
                if (ri == N * N - 1) {
                    return res;
                }
            }
            for (; j > l; j--, ri++) {// движ налево
                res[ri] = a[i][j];
                if (ri == N * N - 1) {
                    return res;
                }
            }
            for (; i > l; i--, ri++) {// движ вверх
                res[ri] = a[i][j];
                if (ri == N * N - 1) {
                    return res;
                }
            }
            i++;
            j++;
            l++;
            r--;
            if (r - l == 1) {
                res[ri] = a[i][j];
                return res;
            } // ситуация, когда остается 1 элемент
        }
        return res;
    }


    private static Scanner inn = new Scanner(System.in);// метод для ввода с клавиатуры

    public static <string> void main(String[] args) {
        int[][] a = createSpiral(10); // тест на примере спиральной матрицы
        Print(a);
        int[] b = snail(a);
        Print(b);// результат



    }
}
