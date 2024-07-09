package Baekjoon.Tree;

import java.io.*;
import java.util.*;

public class Example11725 {
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        DFS(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }


    static void DFS(int v) {
        visited[v] = true;
        for (int current : graph[v]) {
            if (!visited[current]) {
                parent[current] = v;
                DFS(current);
            }
        }
    }
}
