package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example18352 {
    static int N, M, K, X;
    static int[] dist;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        //ArrayList Integer를 저장할 수 있는 ArrayList 객체를 저장하는 ArrayList
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            //정수를 저장할 수 있는 1번부터 n번까지 ArrayList 객체가 있어야 된다. (0번은 무의미함, 버리는 숫자)
            graph.add(new ArrayList<Integer>());
            dist[i] = -1;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        bfs(X);

        for (int i = 0; i <= N; i++) {
            if(dist[i] == K) sb.append(i + "\n");
        }
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    static void bfs(int X) {
        dist[X] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(X);

        while (!q.isEmpty()) { //Queue가 비어있지 않다면 (반복문에서 Queue에서 숫자를 꺼내고 저장하고를 반복)
            int now = q.poll(); //Queue에서 꺼내서 반환하며 삭제

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.offer(next); //Queue에 저장
                }
            }
        }
    }
}
