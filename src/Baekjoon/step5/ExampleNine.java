package Baekjoon.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExampleNine {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String reverseStr1 = new StringBuilder(st.nextToken()).reverse().toString();
        String reverseStr2 = new StringBuilder(st.nextToken()).reverse().toString();

        if (Integer.parseInt(reverseStr1) > Integer.parseInt(reverseStr2)) {
            System.out.println(reverseStr1);
        } else {
            System.out.println(reverseStr2);
        }
    }
}
