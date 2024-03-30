    package Baekjoon.step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = fn(n);
        System.out.println(answer);
        System.out.println(2);
    }

    public static long fn(long n) {
        return (long) n * (n - 1) / 2;
    }
}
