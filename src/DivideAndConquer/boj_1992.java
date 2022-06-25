package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1992 {
    public static int[][] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        position(0, 0, N);
        System.out.println(sb);
    }

    public static void position(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (arr[row][col] == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            return;
        } else {
            sb.append("(");
        }
        int newSize = size / 2;

        position(row, col, newSize);								// 왼쪽 위
        position(row, col + newSize, newSize);					// 오른쪽 위

        position(row + newSize, col, newSize);                    // 왼쪽 아래
        position(row + newSize, col + newSize, newSize);    // 오른쪽 아래
        sb.append(")");

    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
