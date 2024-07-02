package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] D = new int[N + 1][N + 1];

        // INF 값을 100,000,000으로 설정 (최대 비용 100,000 * 최대 도시 수 100)
        final int max_cost = 100000000;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    D[i][j] = 0;
                } else {
                    D[i][j] = max_cost;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // ex> "1 4 1"과 "1 4 2"가 입력으로 들어왔으면, "1 4 1"을 택해야 함.
            D[a][b] = Math.min(D[a][b], c);
        }

        //플로이드-워셜
        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    D[S][E] = Math.min(D[S][E], D[S][K] + D[K][E]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (D[i][j] == max_cost) {
                    D[i][j] = 0;
                }
                sb.append(D[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
