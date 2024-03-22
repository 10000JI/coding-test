package Baekjoon.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExampleTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < arr.length; i++) {
            int a = Integer.parseInt(st.nextToken());
            sb.append(arr[i] - a + " ");
        }
        System.out.println(sb);
    }
}
