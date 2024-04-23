package PrefixSum;

import java.io.*;
import java.util.*;

public class Example2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, sum = 0;
        // 초기 K일 동안의 합 계산
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int answer = sum;

        // K일씩 이동하면서 최대 합 구하기
        for (int rt = k; rt < n; rt++) {
            sum += arr[rt]; // 새로운 온도 추가
            sum -= arr[lt++]; // 이전 온도 제거
            answer = Math.max(answer, sum); // 최대값 갱신
        }
        System.out.println(answer);
    }
}
