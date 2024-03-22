package Baekjoon.step5;

import java.io.*;

public class ExampleOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = String.valueOf(br.readLine());
        int num = Integer.parseInt(br.readLine());

        bw.write(s.charAt(num-1));
        bw.flush();
        bw.close();
    }
}
