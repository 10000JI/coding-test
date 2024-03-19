package Baekjoon.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleSeven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[30];
        for (int i = 0; i < 28; i++) {
            int a = Integer.parseInt(br.readLine());
            answer[a-1] = a;
        }
        for (int i = 0; i < 30; i++) {
            if (answer[i] == 0) {
                System.out.println(i+1);
            }
        }
    }
}
