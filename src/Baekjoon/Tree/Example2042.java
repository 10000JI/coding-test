package Baekjoon.Tree;

import java.io.*;
import java.util.*;
public class Example2042 {
    static long[] tree; // 세그먼트 트리를 저장할 배열
    static int leafStart; // 리프 노드의 시작 인덱스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 개수
        int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수

        int k = (int) Math.ceil(Math.log(N) / Math.log(2)); //2^k >= N인 최소값 k
        leafStart = 1 << k; // 리프 노드의 시작 인덱스 (2^k)
        int size = 2 * leafStart; // 트리 배열의 전체 크기
        tree = new long[size]; // 트리 배열 초기화

        // 리프 노드에 입력 값 저장
        for (int i = 0; i < N; i++) {
            tree[leafStart + i] = Long.parseLong(br.readLine());
        }

        // 부모 노드들의 값을 자식 노드들의 합으로 초기화
        for (int i = leafStart - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 쿼리 타입
            int b = Integer.parseInt(st.nextToken()); // 인덱스 또는 구간 시작
            long c = Long.parseLong(st.nextToken()); // 변경할 값 또는 구간 끝

            if (a == 1) {
                update(b, c); // 값 업데이트
            } else if (a == 2) {
                sb.append(sum(b, (int)c)).append("\n"); // 구간 합 계산 및 결과 저장
            }
        }

        System.out.print(sb);
    }

    // b번째 수를 c로 변경
    public static void update(int index, long value) {
        index = leafStart + index - 1; // 실제 트리 배열에서의 리프노드 인덱스로 변환
        long diff = value - tree[index]; // 변경될 차이 계산
        while (index > 0) {
            tree[index] += diff; // 현재 노드와 모든 부모 노드 업데이트
            index /= 2; // 부모 노드로 이동
        }
    }

    // b번째 수부터 c번째 수까지의 합
    public static long sum(int start, int end) {
        start = leafStart + start - 1; // 시작노드를 실제 트리 배열 인덱스로 변환
        end = leafStart + end - 1; // 끛노드를 실제 트리 배열 인덱스로 변환
        long sum = 0;// 구간 합을 저장할 변수

        while (start <= end) {
            if (start % 2 == 1) sum += tree[start++]; // 시작노드가 오른쪽 자식노드이면 자신의 부모노드가 아닌 오른쪽에 있는 부모노드로 이동 (하단에서 부모로 이동하기 위해 /2)
            if (end % 2 == 0) sum += tree[end--];  // 끝노드가 왼쪽 자식이면 자신의 부모노드가 아닌 왼쪽에 있는 부모노드로 이동 (하단에서 부모로 이동하기 위해 /2)
            start /= 2;
            end /= 2;
        }
        return sum;
    }
}
