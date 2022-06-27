package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1517 {
    static Long[] arr;
    static Long[] tmp;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new Long[N];
        tmp = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        sort(0, N - 1);

        System.out.println(cnt);
    }

    public static void sort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            sort(start, mid);
            sort(mid + 1, end);

            int i = start;
            int j = mid + 1;
            int k = start;

            while (i <= mid && j <= end) {
                if (arr[i] <= arr[j]) {
                    tmp[k++] = arr[i++];
                } else {
                    tmp[k++] = arr[j++];
                    cnt += mid - i + 1;
                }
            }

            while (i <= mid) {
                tmp[k++] = arr[i++];
            }
            while (j <= end) {
                tmp[k++] = arr[j++];
            }

            for (int l = start; l <= end; l++) {
                arr[l] = tmp[l];
            }
        }
    }
}
