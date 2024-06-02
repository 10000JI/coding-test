package Baekjoon.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
//dfs 방법, 시간복잡도 문제가 있을 수 있음 (통과 될 때도 있고, 실패가 뜰 때도 있드라..)
public class Example1325_2 {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int[] cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (cnt[i] ==max) {
                sb.append(i).append(" ");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    static void dfs(int now) {
        visited[now] = true;
        for (int next : graph[now]) {
            if (!visited[next]) {
                cnt[next]++;
                dfs(next);
            }
        }
    }
}
