package section7;

import java.util.Scanner;

//경로 탐색(인접행렬)
public class ExampleEleven {
    static int n,m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v) {
        //5번 노드에 도달했을때 answer를 1 증가
        if(v==n) answer++;
        else{
            // 행은 v로 고정하고, 열은 1~5가 돌아가며 for문
            for (int i = 1; i <= n; i++) {
                // 해당 노드가 1이고, ch(=check)배열 값이 0이라면
                if (graph[v][i] == 1 && ch[i] == 0) {
                    //ch[i] 값을 1로 변경
                    ch[i] = 1;
                    //재귀함수 동작, graph 배열의 행을 i로 하여 반복
                    DFS(i);
                    //DFS가 Stack 형태에서 하나씩 꺼내질 때 (되돌아갈 때 = 5번 노드에 도달했을 때) ch(=check)는 1에서 0으로 바꿔줘야 함
                    //그래야 다른 경우의 수도 셀 수 있음
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        ExampleEleven T = new ExampleEleven();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        //이차원 배열, 인접행렬
        graph = new int[n+1][n+1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            //입력한 노드의 값은 1
            graph[a][b] = 1;
        }
        //1에서 출발 시 ch[1]을 1로 세팅 (1행1열에서 출발해서)
        ch[1] = 1;
        //DFS 시작
        T.DFS(1);
        //5번 노드에 도달한 경우의 수
        System.out.println(answer);
    }
}
