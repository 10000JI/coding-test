package Baekjoon.step9;

import java.io.*;

public class ExampleFive {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean found = false;
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // 에라토스테네스의 체 : 소수가 아닌 수 제거
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                sum += i;
                min = Math.min(min, i);
                found = true;
            }
        }

        if (!found) { // 소수가 없는 경우
            sb.append("-1");
        } else {
            sb.append(sum).append("\n").append(min);
        }

        System.out.println(sb);
    }
}
