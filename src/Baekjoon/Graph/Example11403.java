package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] D = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //플로이드-워셜
        for (int K = 0; K < N; K++) {
            for (int S = 0; S < N; S++) {
                for (int E = 0; E < N; E++) {
                    if (D[S][K] == 1 && D[K][E] == 1) {
                        D[S][E] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(D[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
