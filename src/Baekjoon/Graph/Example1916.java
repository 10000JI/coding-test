package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        //인접 리스트
        ArrayList<Node>[] grape = new ArrayList[N + 1];
        //최단거리 배열
        int[] D = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            grape[i] = new ArrayList<>();
            D[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            grape[A].add(new Node(B, C));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //다익스트라 -> 우선순위 큐
        PriorityQueue<Node> que = new PriorityQueue<>();
        //출발 도시 최단거리 0
        D[start] = 0;
        que.offer(new Node(start, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();

            if (now.e > D[now.toNode]) continue;  // 이미 더 짧은 경로를 찾았다면 스킵

            for (Node next : grape[now.toNode]) {
                int newCost = D[now.toNode] + next.e;
                if (newCost < D[next.toNode]) {
                    D[next.toNode] = newCost;
                    que.offer(new Node(next.toNode, newCost));
                }
            }
        }
        System.out.println(D[end]);
    }

    static class Node implements Comparable<Node> {
        int toNode;
        int e;
        @Override
        public int compareTo(Node node) { //가중치 비교 (작은 값)
            return this.e - node.e;
        }

        public Node(int toNode, int e) {
            this.toNode = toNode;
            this.e = e;
        }
    }
}
