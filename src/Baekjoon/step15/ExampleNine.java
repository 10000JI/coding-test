package Baekjoon.step15;

import java.io.*;

public class ExampleNine {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count++;
        }

        System.out.println(count);
    }
}

