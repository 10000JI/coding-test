package Baekjoon.step15;

import java.io.*;
import java.util.*;

public class ExampleOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCM(a, b)).append("\n");
        }
        System.out.println(sb);

    }

    //최대공약수 구하기
    public static int GCD(int a, int b) {
        //r은 나머지
        int r = a % b;
        //나머지가 0이면 작은 숫자가 최대 공약수
        if (r == 0) {
            return b;
        } else {
            //b가 a자리로, a % b가 b자리로
            return GCD(b, a % b); // 재귀함수, r이 0이 될 때까지
        }
    }

    //최소공배수 구하기
    public static int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
}
