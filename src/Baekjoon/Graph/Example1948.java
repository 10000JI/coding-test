package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example1948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 정방향 그래프
        ArrayList<ArrayList<Node>> reverse_graph = new ArrayList<>(); // 역방향 그래프

        for (int i = 0; i <= n; i++) { //크기 +1만큼은 더 크게 해줘야함 (i<=n)
            graph.add(new ArrayList<Node>());
            reverse_graph.add(new ArrayList<Node>());
        }
        // 진입차수 저장 배열
        int[] indegree = new int[n + 1];
        // 각 출발 도시(시작노드)부터 도착 도시(마지막노드)까지 거리
        int[] path = new int[n + 1];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            //정방향: a->b, a에서 b까지의 가중치 = e
            graph.get(a).add(new Node(b, e));
            //다음 노드를 진입차수 대상으로 두고 +1
            indegree[b]++;
            //역방향: b->a, b에서 a까지의 가중치 = e
            reverse_graph.get(b).add(new Node(a, e));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //위상정렬
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        while (!que.isEmpty()) {
            int now = que.poll();
            for (Node node : graph.get(now)) {
                //다음 노드를 진입차수 대상으로 두고 -1
                indegree[node.toNode]--;
                //동일 노드에 간선이 둘 이상이면(=진입차수가 0보다 큰 경우) Math.max 작용 (큰값 대입)
                path[node.toNode] = Math.max(path[node.toNode], path[now] + node.e);
                //진입차수가 0이면 que에 추가
                if (indegree[node.toNode] == 0) {
                    que.offer(node.toNode);
                }
            }
        }

        // 역위상정렬
        que.offer(end);
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        visited[end] = true;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (Node node : reverse_graph.get(now)) {
                //도달 정점에서의 최대 비용 + 간선에서 소모한 비용 = 최대 비용(고정 값일 것)
                if (path[now] == path[node.toNode] + node.e) {
                    cnt++;
                    if (!visited[node.toNode]) {
                        que.offer(node.toNode);
                        visited[node.toNode] = true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(path[end]).append("\n");
        sb.append(cnt);
        System.out.println(sb);
    }

    static class Node {
        int toNode; // 다음 노드
        int e; // 현재 노드와 다음 노드 간의 간선의 가중치

        public Node(int toNode, int e) {
            this.toNode = toNode;
            this.e = e;
        }
    }
}
