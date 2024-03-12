package Baekjoon.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExampleSix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        if (B + C >= 60) {
            A = A + 1;
            B = B + C - 60;
            while (B >= 60) {
                A = A + 1;
                B = B - 60;
            }
        } else {
            B = B + C;
        }
        if (A >= 24) {
            A = A - 24;
        }
        System.out.println(A+" "+B);
    }
}
