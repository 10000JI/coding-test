package Baekjoon.step7;

import java.io.*;
import java.util.*;

public class ExampleTwo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[9][9];
        int max = 0;
        int[] answer = new int[2];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        sb.append(max).append("\n");
        sb.append(answer[0]+1).append(" ").append(answer[1]+1);
        System.out.println(sb);
    }
}
