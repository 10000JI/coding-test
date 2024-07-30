package Baekjoon.Tree;

import java.io.*;
import java.util.*;

public class Example11505 {
    static long[] tree;
    static int leafStart;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int k = (int) Math.ceil(Math.log(N) / Math.log(2));
        leafStart = 1 << k;
        int size = 2 * leafStart;

        tree = new long[size];

        // 리프 노드 초기화
        for (int i = 0; i < N; i++) {
            tree[leafStart + i] = Integer.parseInt(br.readLine());
        }

        // 나머지 노드 초기화
        for (int i = leafStart - 1; i > 0; i--) {
            tree[i] = (tree[2 * i] * tree[2 * i + 1]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(b, c);
            } else if (a == 2) {
                sb.append(multiply(b, c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static void update(int index, long value) {
        index = leafStart + index - 1;
        tree[index] = value;
        while (index > 1) {
            index /= 2;
            tree[index] = (tree[2 * index] * tree[2 * index + 1]) % MOD;
        }
    }

    public static long multiply(int start, int end) {
        start = leafStart + start - 1;
        end = leafStart + end - 1;
        long result = 1;

        while (start <= end) {
            if (start % 2 == 1) result = (result * tree[start++]) % MOD;
            if (end % 2 == 0) result = (result * tree[end--]) % MOD;
            start /= 2;
            end /= 2;
        }

        return result;
    }
}