package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] D = new int[N + 1][N + 1];
        int cost_max = 50000;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = cost_max;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // 양방향 설계 (a->b, b->a)
            D[A][B] = D[B][A] = 1;
        }

        //플로이드 워셜
        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    D[S][E] = Math.min(D[S][E], D[S][K] + D[K][E]);
                }
            }
        }

        int index = 0;
        int res = cost_max;
        // 가장 적은 값을 가진 인덱스 출력
        for (int i = 1; i <= N; i++) {
            int value = 0; // i=1, i=2, i=2.. 각 유저로 취급
            for (int j = 1; j <= N; j++) {
                value += D[i][j]; // 유저의 케빈 베이컨 수
            }

            if (res > value) {
                res = value;
                index = i;
            }
        }

        System.out.println(index);
    }
}
