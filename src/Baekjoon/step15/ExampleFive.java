package Baekjoon.step15;

import java.io.*;
import java.math.BigInteger;

public class ExampleFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        for (int i = 0; i < numbers.length; i++) {
            BigInteger bigInteger = new BigInteger(String.valueOf(numbers[i]));
            if (bigInteger.isProbablePrime(10)) {
                sb.append(bigInteger + "\n");
            } else {
                sb.append(bigInteger.nextProbablePrime() + "\n");
            }
        }
        System.out.println(sb);
    }
}
