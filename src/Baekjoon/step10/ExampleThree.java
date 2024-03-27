package Baekjoon.step10;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleThree {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];
        int answerX, answerY;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        if (x[0] == x[1]) {
            answerX = x[2];
        } else if (x[0] == x[2]) {
            answerX = x[1];
        } else {
            answerX = x[0];
        }

        if (y[0] == y[1]) {
            answerY = y[2];
        } else if (y[0] == y[2]) {
            answerY = y[1];
        } else {
            answerY = y[0];
        }
        System.out.println(answerX + " " + answerY);
    }
}
