package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;

public class Example1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0, rt = 0, sum = 0, answer = Integer.MAX_VALUE;
        while (lt <= rt) {
            if (sum >= s) {
                answer = Math.min(answer, rt - lt);
                sum -= arr[lt++];
            }else if(rt == n) break;
            else {
                sum += arr[rt++];
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

}
