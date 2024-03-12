package Baekjoon.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ExampleTen {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int firstResult = A * (B % 10);
        int secondResult = A * (B % 100 / 10);
        int thirdResult = A * (B / 100);
        int finalResult = A * B;

        System.out.println(firstResult);
        System.out.println(secondResult);
        System.out.println(thirdResult);
        System.out.println(finalResult);
    }
}
