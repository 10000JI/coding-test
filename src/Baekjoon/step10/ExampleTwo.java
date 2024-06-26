package Baekjoon.step10;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleTwo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int answer = Math.min(Math.min(x, w - x), Math.min(y, h - y));
        System.out.println(answer);
    }
}
