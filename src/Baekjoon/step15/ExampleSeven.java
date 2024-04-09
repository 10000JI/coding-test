package Baekjoon.step15;

import java.io.*;
import java.util.*;

public class ExampleSeven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int twiceN = 2 * n;

            // true: 소수x , false: 소수
            boolean[] isNotPrime = new boolean[twiceN + 1];
            isNotPrime[0] = isNotPrime[1] = true;

            for (int i = 2; i * i <= twiceN; i++) {
                if (!isNotPrime[i]) {
                    for (int j = i * i; j <= twiceN; j += i) {
                        isNotPrime[j] = true;
                    }
                }
            }

            int count = 0;
            for (int i = n+1; i <= twiceN; i++) {
                if (!isNotPrime[i]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
