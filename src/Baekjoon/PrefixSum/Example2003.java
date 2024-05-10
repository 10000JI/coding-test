package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;

public class Example2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0, sum = 0, answer = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if(sum==m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if(sum==m) answer++;
            }
        }
        System.out.println(answer);
    }
}
