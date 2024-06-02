package Baekjoon.Graph;

import java.io.*;
import java.util.*;

//bfs방법
public class Example1325 {
    static int N,M,memo[],max;
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        memo = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int v = q.poll();
                for (int next : graph[v]) {
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                        memo[next]++;
                    }
                }
            }
        }

        for (int value : memo) {
            max = Math.max(max, value);
        }
        for (int i = 1; i <= N; i++) {
            if (memo[i] == max)
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
