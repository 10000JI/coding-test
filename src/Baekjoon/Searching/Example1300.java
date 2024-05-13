package Baekjoon.Searching;

import java.io.*;
import java.util.*;

public class Example1300 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int lt = 1, rt = k, answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt=0;

            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt < k) {
                lt = mid + 1;
            } else {
                answer = mid;
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
