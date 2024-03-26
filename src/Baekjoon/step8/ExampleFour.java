package Baekjoon.step8;

import java.io.*;

public class ExampleFour {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int pow = 2;
        int answer = 0;
        for (int i = 0; i < num; i++) {
            pow += (int) Math.pow(2, i);
            answer = (int) Math.pow(pow, 2);
        }
        System.out.println(answer);
    }
}
