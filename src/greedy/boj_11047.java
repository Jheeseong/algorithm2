package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047 {
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        coinMin(arr, cost);
        System.out.println(cnt);
    }

    public static void coinMin(int[] arr, int cost) {
        if (cost == 0) {
            return;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= cost) {

                cnt += (cost / arr[i]);
                cost = cost % arr[i];
            }
        }
    }
}
