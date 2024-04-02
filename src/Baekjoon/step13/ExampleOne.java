package Baekjoon.step13;

import java.io.*;
import java.util.*;

public class ExampleOne {
    public static void main(String[] args) throws IOException {
        /**
         * 1. Arrays.sort() 이용
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        Arrays.sort(arr);
//        for (int i = 0; i < n; i++) {
//            sb.append(arr[i]).append("\n");
//        }
//        System.out.println(sb);
//        br.close();
        /**
         * 2. 선택정렬 풀이
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        for (int answer : arr) {
            System.out.println(answer);
        }
    }
}
