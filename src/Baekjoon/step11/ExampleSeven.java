package Baekjoon.step11;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleSeven {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int answer = 1;
        for (int n = n0; n <= 100; n++) {
            // f(n) ≤ c × g(n) 식에 적합하지 않다면
            int fn = a1 * n + a0;
            if (fn > c * n) {
                answer = 0;
                break;
            }
        }

        System.out.println(answer);
    }
}
