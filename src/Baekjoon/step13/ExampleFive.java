package Baekjoon.step13;

import java.io.*;
import java.util.*;

public class ExampleFive {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];

        for (int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }
        br.close();

        for (int i = 1; i < 10001; i++) {
            while (cnt[i] > 0) {//빈도수(중복)
                sb.append(i).append('\n');
                cnt[i]--; //while문 조건에서 빠져나가기 위한
            }
        }
        System.out.println(sb);
    }
}

