package Baekjoon.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleThree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            char start = str.charAt(0);
            char end = str.charAt(str.length() - 1);
            System.out.println(Character.toString(start)+Character.toString(end));
        }
        br.close();
    }
}
