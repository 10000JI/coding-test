package Baekjoon.step8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExampleTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % b;
            if (r < 10) {
                //이전과 반대로 작업
                sb.append((char)(r + '0'));
            } else {
                //이전과 반대로 작업
                sb.append((char)((r + 'A' - 10)));
            }
            n /= b;
        }
        System.out.println(sb.reverse().toString());
    }
}
