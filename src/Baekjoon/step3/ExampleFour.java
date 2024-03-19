package Baekjoon.step3;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleFour {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            total += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }
        if (X == total) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
    }
}
