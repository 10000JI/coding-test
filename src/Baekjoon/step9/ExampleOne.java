package Baekjoon.step9;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleOne {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b==0) {
                break;
            }
            if (a < b && b % a == 0) {
                System.out.println("factor");
            } else if (a > b && a % b == 0) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }
    }
}
