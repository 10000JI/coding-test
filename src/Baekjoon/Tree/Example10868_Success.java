package Baekjoon.Tree;

import java.io.*;
import java.util.*;

public class Example10868_Success {
    static long[] tree;
    static int N, leafStart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int k = (int) Math.ceil(Math.log(N) / Math.log(2));
        leafStart = 1 << k; // 리프 노드의 시작 인덱스 (2^k)
        int size = 2 * leafStart; // 트리 배열의 전체 크기
        tree = new long[size]; // 트리 배열 초기화

        // 리프 노드에 입력 값 저장
        for (int i = 0; i < N; i++) {
            tree[leafStart + i] = Long.parseLong(br.readLine());
        }

        // 부모 노드들의 값을 자식 노드들의 비교로 최솟값 대입
        for (int i = leafStart - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(min(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    public static long min(int start, int end) {
        start = leafStart + start - 1;
        end = leafStart + end - 1;
        long minValue = Long.MAX_VALUE;

        while (start <= end) {
            if (start % 2 == 1) minValue = Math.min(tree[start++], minValue);
            if (end % 2 == 0) minValue = Math.min(tree[end--], minValue);
            start /= 2;
            end /= 2;
        }

        return minValue;
    }
}
