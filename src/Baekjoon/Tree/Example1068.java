package Baekjoon.Tree;

import java.io.*;
import java.util.*;

public class Example1068 {
    static ArrayList<Integer>[] grape;
    static int[] leaf;
    static int N, target, root; // N: 노드 개수, target: 삭제할 노드, root: 루트 노드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //N은 50보다 작거나 같은 자연수
        leaf = new int[N];
        grape = new ArrayList[N + 1]; //인접리스트 초기화 (리스트의 배열(또는 리스트의 리스트))

        for (int i = 0; i < N; i++) {
            grape[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                grape[parent].add(i); // 부모 노드에 자식 노드 추가
            }
        }
        target = Integer.parseInt(br.readLine()); //지울 노드의 번호

        for (int i = 0; i < N; i++) {
            grape[i].removeIf(integer -> integer == target); // 삭제할 노드를 자식으로 가진 노드에서 제거
            //그래프 속 지울 노드의 번호 삭제
        }
        if(target != root) DFS(root, -1);// 루트가 삭제 대상이 아닐 경우에만 DFS 수행

        System.out.println(leaf[root]);
    }

    static void DFS(int v, int parent) {
        if(grape[v].isEmpty()) leaf[v] = 1; //자식이 없다면 그 노드는 리프 노드

        for (int child : grape[v]) {
            DFS(child,v);
            leaf[v] += leaf[child];// 자식 노드의 리프 노드 개수를 현재 노드에 더함
        }
    }

}
