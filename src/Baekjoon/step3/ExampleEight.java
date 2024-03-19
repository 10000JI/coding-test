package Baekjoon.step3;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleEight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(String.format("Case #%d: %d + %d = %d", i, a, b, (a + b))).append("\n");
        }
        System.out.println(sb);
    }
}
