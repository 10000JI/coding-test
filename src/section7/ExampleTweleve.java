package section7;

import java.util.ArrayList;
import java.util.Scanner;

//경로 탐색(인접리스트)
public class ExampleTweleve {
    static int n,m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int v) {
        if(v==n) answer++;
        else{
            //v 정점에 갈 수 있는 것은 v번 ArrayList에 추가되어 있음
            for (int nv : graph.get(v)) {
                // v번 ArrayList에 저장되어 있는 것(nv)들 중 체크배열(ch[nv])이 0 이라면
                if (ch[nv] == 0) {
                    //체크배열(ch[nv])를 1로 만들고
                    ch[nv] = 1;
                    //nv번 ArrayList를 찾아 재귀함수 출동
                    DFS(nv);
                    //되돌아갈 때 (= 5번 노드에 도달했을 때) ch[nv]는 1에서 0으로 바꿔줘야 함
                    ch[nv] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        ExampleTweleve T = new ExampleTweleve();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        //ArrayList Integer를 저장할 수 있는 ArrayList 객체를 저장하는 ArrayList
        graph = new ArrayList<ArrayList<Integer>>();
        //정수를 저장할 수 있는 1번부터 n번까지 ArrayList 객체가 있어야 된다. (0번은 무의미함, 버리는 숫자)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            //a번 ArrayList에 접근, a번 ArrayList에 b를 추가
            //ex> 3번 노드 ArrayList에 5번 노드 추가 (3->5)
            graph.get(a).add(b);
        }
        ch[1] = 1;
        //DFS 시작
        T.DFS(1);
        //5번 노드에 도달한 경우의 수
        System.out.println(answer);
    }
}
