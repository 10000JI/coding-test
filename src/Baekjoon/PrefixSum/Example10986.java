package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;

public class Example10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 받기
        int n = Integer.parseInt(st.nextToken()); // 배열의 길이
        int m = Integer.parseInt(st.nextToken()); // 나눌 수

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n]; // 입력 배열
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Prefix Sum 배열 생성
        long sum = 0;
        long[] count = new long[m]; // 나머지 카운트 배열
        long result = 0; // 결과값

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            sum %= m; // 나머지 계산
            count[(int) sum]++; // 나머지 카운트 증가
        }

        // 나머지가 0인 경우 처리
        result += count[0];

        // 나머지가 같은 부분 합에서 2개씩 뽑는 조합 계산
        for (int i = 0; i < m; i++) {
            result += (count[i] * (count[i] - 1)) / 2;
        }

        System.out.println(result); // 결과 출력
    }
}
