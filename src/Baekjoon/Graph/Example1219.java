package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example1219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 도시의 수
        int start = Integer.parseInt(st.nextToken());  // 시작 도시
        int destination = Integer.parseInt(st.nextToken());  // 도착 도시
        int M = Integer.parseInt(st.nextToken());  // 교통 수단의 개수

        Edge[] grape = new Edge[M + 1];  // 교통 수단(간선) 정보를 저장할 배열
        long[] dist = new long[N + 1];  // 각 도시까지의 최대 수익을 저장할 배열

        // 교통 수단 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());  // 출발 도시
            int b = Integer.parseInt(st.nextToken());  // 도착 도시
            int c = Integer.parseInt(st.nextToken());  // 교통 비용
            grape[i] = new Edge(a, b, c);
        }

        // 각 도시에서 벌 수 있는 돈 입력
        long[] money = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        // 벨만 포드 알고리즘 시작
        Arrays.fill(dist, Long.MIN_VALUE);  // 모든 도시의 초기 수익을 최소값으로 설정
        dist[start] = money[start];  // 시작 도시의 수익 초기화

        // N+50번 반복 (양의 사이클 검출을 위해 충분히 큰 횟수로 설정)
        for (int i = 0; i <= N + 50; i++) {
            for (int j = 0; j < M; j++) {
                Edge now = grape[j];
                // 출발 도시에 도달할 수 없는 경우 스킵
                if (dist[now.st] == Long.MIN_VALUE) {
                    continue;
                }
                // 출발 도시가 양의 사이클에 포함된 경우, 도착 도시도 무한대 수익으로 설정
                else if (dist[now.st] == Long.MAX_VALUE) {
                    dist[now.end] = Long.MAX_VALUE;
                }
                // 수익이 증가하는 경우 업데이트
                else if (dist[now.end] < dist[now.st] + money[now.end] - now.cost) {
                    dist[now.end] = dist[now.st] + money[now.end] - now.cost;
                    // N번 이상 반복했을 때 여전히 업데이트가 발생하면 양의 사이클로 판단
                    if (i >= N) {
                        dist[now.end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 도착 도시에 도달할 수 없는 경우
        if (dist[destination] == Long.MIN_VALUE) {
            sb.append("gg").append("\n");
        }
        // 도착 도시가 양의 사이클에 포함된 경우
        else if (dist[destination] == Long.MAX_VALUE) {
            sb.append("Gee").append("\n");
        }
        // 정상적으로 도착 도시에 도달한 경우
        else {
            sb.append(dist[destination]).append("\n");
        }
        System.out.println(sb);
    }

    // 간선(교통 수단) 정보를 저장하는 클래스
    static class Edge{
        int st;  // 출발 도시
        int end;  // 도착 도시
        int cost;  // 비용

        public Edge(int st, int end, int cost) {
            this.st = st;
            this.end = end;
            this.cost = cost;
        }
    }
}