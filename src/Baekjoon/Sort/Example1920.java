package Baekjoon.Sort;

import java.io.*;
import java.util.*;

public class Example1920 {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();
         int n = Integer.parseInt(br.readLine());
         int[] arr = new int[n];
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < n; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }

         int m = Integer.parseInt(br.readLine());
         Arrays.sort(arr); //이진탐색 정렬 후 사용
         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < m; i++) {
             if (binarySearch(arr, Integer.parseInt(st.nextToken())) == 1) {
                 sb.append(1).append("\n");
             } else sb.append(0).append("\n");
         }
         System.out.println(sb);
     }

     //이진탐색
    static int binarySearch(int[] arr, int t) {
        int lt = 0, rt = arr.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (t == arr[mid]) {
                return 1;
            } else if (t < arr[mid]) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return 0;
    }
}
