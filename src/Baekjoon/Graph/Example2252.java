package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //진입차수 저장 배열
        int[] arr = new int[n + 1];
        //그래프 2차원 리스트
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b); //a가 b 앞에 선다. = a가 b를 가리킨다.  2차원 리스트 정보 초기화
            arr[b]++; //b의 진입차수 +1
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) { //i의 진입차수 값이 0이라면
                que.offer(i); //큐에 저장
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!que.isEmpty()) {
                int num = que.poll(); // 큐에서 꺼냄 (동시에 삭제)
                sb.append(num).append(" "); //반환값에 추가

                for (int j = 0; j < list.get(num).size(); j++) {
                    int edge  = list.get(num).get(j); // 만약 num이 4이고, 4가 가리키는 숫자가 2였다면 edge는 2를 반환
                    arr[edge]--; // edge의 진입차수 -1
                    if (arr[edge] == 0) { // edge가 0이 되면 큐에 저장
                        que.offer(edge);
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
