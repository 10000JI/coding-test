package Baekjoon.Searching;

import java.io.*;
import java.util.*;

public class Example11724 {

    static int n,m, components = 0;
    static boolean[][] graph;
    static boolean[] ch;

    static void DFS(int v) {
        ch[v] = true;
        for (int i = 1; i <= n; i++) {
            if (graph[v][i] && !ch[i]) {
                //무방향에선 1행 1열, 2행 2열, 3행 3열 ,, 등은 무조건 flase
                DFS(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new boolean[n + 1][n + 1];
        ch = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!ch[i]) {
                DFS(i);
                components++;
            }
        }
        System.out.println(components);
    }

}

