package Baekjoon.Searching;

import java.io.*;
import java.util.*;

public class Example1260 {

    static int m, n, v;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken()); //정점 개수
        m = Integer.parseInt(st.nextToken()); //간선 개수
        v = Integer.parseInt(st.nextToken()); //정점 번호
        arr = new ArrayList[n + 1]; //배열 크기 설정

        for (int i = 1; i < n + 1; i++) {
            arr[i] = new ArrayList<Integer>(); //정점마다 인접 리스트 저장
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1].add(v2);
            arr[v2].add(v1);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[n + 1];
        DFS(v);
        sb.append("\n");

        visited = new boolean[n + 1];
        BFS(v);

        System.out.println(sb);
    }


    static void BFS(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");
            for (int i = 0; i < arr[node].size(); i++) {
                if(visited[arr[node].get(i)]==true) continue;
                q.add(arr[node].get(i));
                visited[arr[node].get(i)] = true;
            }
        }
    }

    static void DFS(int x) {
        if (visited[x] == false) {
            sb.append(x).append(" ");
            visited[x] = true;
        }

        for (int i = 0; i < arr[x].size(); i++) {
            if(visited[arr[x].get(i)]==true) continue;
            DFS(arr[x].get(i));
        }
    }
}
