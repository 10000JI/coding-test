package Baekjoon.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Example1068_2 {
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;
    static int N, target, answer; // N: 노드 개수, target: 삭제할 노드, root: 루트 노드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //N은 50보다 작거나 같은 자연수
        graph = new ArrayList[N + 1]; //인접리스트 초기화 (리스트의 배열(또는 리스트의 리스트))
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        int root = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                // p 가 i 노드의 부모 노드임
                graph[i].add(parent);
                graph[parent].add(i); // 서로 연결
            }
        }
        target = Integer.parseInt(br.readLine()); //지울 노드의 번호

        if (target == root) {
            System.out.println(0);
            return;
        } else {
            DFS(root);
        }
        System.out.println(answer);
    }

    static void DFS(int v) {
        visited[v] = true;

        int children = 0;
        for (int current : graph[v]) {
            if (current != target && !visited[current]) {
                children++;
                DFS(current);
            }
        }
        if (children == 0) {
            answer++; //자식노드가 없므면 리프노드
        }
    }

}
