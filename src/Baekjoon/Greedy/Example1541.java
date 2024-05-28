package Baekjoon.Greedy;

import java.io.*;
import java.util.*;

public class Example1541 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-"); //구분자 "-"가 포함되지 않아도 하나의 토큰으로 간주됨
        int sum = Integer.MAX_VALUE;
        while (st1.hasMoreTokens()) { //따라서 "-"가 포함되지 않아도 하나의 토큰이므로 while문 실행
            int tmp = 0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
            while (st2.hasMoreTokens()) {
                tmp += Integer.parseInt(st2.nextToken());
            }
            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}
