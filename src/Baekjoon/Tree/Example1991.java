package Baekjoon.Tree;

import java.io.*;
import java.util.*;

public class Example1991 {
    static Node[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        graph = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (graph[parentValue - 'A'] == null) { // 부모 노드가 생성되지 않은 경우
                graph[parentValue - 'A'] = new Node(parentValue);
            }
            if (leftValue != '.') {// '.'이 아니라면 (부모의 왼쪽 자식 노드가 존재한다면)
                graph[leftValue - 'A'] = new Node(leftValue); // 왼쪽 자식 노드 생성
                graph[parentValue - 'A'].lt = graph[leftValue - 'A']; // 부모 노드와 왼쪽 자식 노드 연결
            }
            if (rightValue != '.') {// '.'이 아니라면 (부모의 오른쪽 자식 노드가 존재한다면)
                graph[rightValue - 'A'] = new Node(rightValue); // 오른쪽 자식 노드 생성
                graph[parentValue - 'A'].rt = graph[rightValue - 'A']; // 부모 노드와 오른쪽 자식 노드 연결
            }
        }

        preorder(graph[0]);
        System.out.println(); //엔터

        inorder(graph[0]);
        System.out.println(); //엔터

        postorder(graph[0]);
        System.out.println(); //엔터
    }

    static class Node {
        char data;
        Node lt, rt; //인스턴스 변수 lt,rt는 Node라는 객체 주소 저장

        public Node(char val) {
            data = val;
            lt = rt = null;
        }
    }

    //전위 순회 (dfs)
    public static void preorder(Node node) {
        if(node ==null) return;
        System.out.print(node.data);
        preorder(node.lt);
        preorder(node.rt);
    }
    //증위 순회 (dfs)
    public static void inorder(Node node) {
        if(node ==null) return;
        inorder(node.lt);
        System.out.print(node.data);
        inorder(node.rt);
    }
    //후위 순회 (dfs)
    public static void postorder(Node node) {
        if(node ==null) return;
        postorder(node.lt);
        postorder(node.rt);
        System.out.print(node.data);
    }
}
