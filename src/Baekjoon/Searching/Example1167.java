package Baekjoon.Searching;

import java.io.*;
import java.util.*;

public class Example1167 {

    static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

    static List<Node>[] arr;
    static boolean[] visited;
    static int max = 0;
    static int node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        arr = new ArrayList[v + 1];
        visited = new boolean[v + 1];

        for (int i = 1; i < v + 1; i++) { //공간확보
            arr[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); //기준이 되는 정점
            while (true) {
                int e = Integer.parseInt(st.nextToken()); //다음 정점
                if(e == -1) break; //-1 입력하면 while문 빠져나옴
                int cost = Integer.parseInt(st.nextToken()); //다음 정점까지의 거리
                arr[num].add(new Node(e, cost)); //Node 타입을 가진 ArrayList에 대입
            }
        }

        dfs(1, 0);  // 임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장

        visited = new boolean[v + 1];
        dfs(node, 0); //node에서 부터 가장 먼 노트까지의 거리

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        visited[x] = true; //거쳐 간 정점이니 true

        for (int i = 0; i < arr[x].size(); i++) {
            Node n = arr[x].get(i);
            if (visited[n.e] == false) { //이미 거쳐 간 정점일수도 있으니 방문하지 않은 정점(false)만 조건문
                dfs(n.e, n.cost + len); //길이가 연쇄적으로 이어짐
            }
        }
    }
}
