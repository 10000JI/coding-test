package Baekjoon.Tree;

import java.io.*;
import java.util.*;

// 시간초과
// 쿼리마다 O(N)의 시간 복잡도를 가지게되어 M개의 쿼리에 대해 이를 반복하면
// 전체 시간복잡도는 O(N*M)이 되어, N과 M이 큰 경우 시간 초과가 발생
public class Example10868_Fail {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new long[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(min(a, b)).append("\n"); // 구간 합 계산 및 결과 저장
        }
        System.out.println(sb);
    }

    public static long min(int start, int end) {
        long minValue = Long.MAX_VALUE;
        for (int i = start - 1; i < end; i++) {
            minValue = Math.min(minValue, arr[i]);
        }
        return minValue;
    }
}
