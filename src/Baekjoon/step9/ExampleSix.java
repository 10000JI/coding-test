package Baekjoon.step9;

import java.io.*;

import static java.lang.Math.sqrt;

public class ExampleSix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        //sqrt: math 클래스의 메서드로, 양의 제곱급
        for (int i = 2; i <= sqrt(n); i++) {
            while (n % i == 0) {
                sb.append(i).append('\n');
                n /= i; // n을 i로 나누어주어야 합니다.
            }
        }

        if (n != 1) {
            sb.append(n);
        }
        System.out.println(sb);
    }
}
