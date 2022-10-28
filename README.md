## Snail(4kyu)
## 28.10.2022
## получение из двумерного массива одномерного двигаясь по спирали по часовй стрелке 
## [ссылка на задание](https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java)
## Код:
``` java
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
    
```
## понравивщееся решение (автор nightori)
``` java
public class Snail {

    public static int[] snail(int[][] array) {
      if (array[0].length == 0) return new int[0];
      int n = array.length;
      int[] answer = new int[n*n];
      int index=0;
      for (int i = 0; i<n/2; i++){
        for (int j = i; j < n-i; j++) answer[index++] = array[i][j];
        for (int j = i+1; j < n-i; j++) answer[index++] = array[j][n-i-1];
        for (int j = i+1; j < n-i; j++) answer[index++] = array[n-i-1][n-j-1];
        for (int j = i+1; j < n-i-1; j++) answer[index++] = array[n-j-1][i];
      }
      if (n%2 != 0) answer[index++] = array[n/2][n/2];
      return answer;
    } 
}
  
