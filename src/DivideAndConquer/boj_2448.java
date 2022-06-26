package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2448 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                arr[i][j] = ' ';
            }
        }

        triangle(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void triangle(int x, int y, int N) {

        if (N == 3) {
            arr[x][y] = '*';
            arr[x + 1][y - 1] = arr[x + 1][y + 1] = '*';
            arr[x + 2][y - 2] = arr[x + 2][y - 1] = arr[x + 2][y] = arr[x + 2][y + 1] = arr[x + 2][y + 2] = '*';
            return;
        }

        triangle(x, y, N / 2);
        triangle(x + N / 2, y - N / 2, N / 2);
        triangle(x + N / 2, y + N / 2, N / 2);
    }
}
