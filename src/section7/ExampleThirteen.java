package section7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//그래프 최단거리(BFS)
public class ExampleThirteen {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    static void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        //Queue에 1 추가
        Q.offer(v);
        while (!Q.isEmpty()) {
            //Queue에 있는 요소를 꺼내면서 (삭제하면서) cv에 대입
            int cv = Q.poll();
            for (int nv : graph.get(cv)) {
                //check 배열이 0이라면 (최초방문)
                if (ch[nv] == 0) {
                    //방문했으니 check 배열은 1로 변경
                    ch[nv] = 1;
                    //Queue에 nv 추가
                    Q.offer(nv);
                    //노드 nv는 노드 cv에서 + 1 만큼의 거리
                    dis[nv] = dis[cv] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        ExampleThirteen T = new ExampleThirteen();
        Scanner kb = new Scanner(System.in);
        //정점의 개수
        n = kb.nextInt();
        //간선의 개수
        m = kb.nextInt();
        //인접리스트 공간 확보
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        //체크배열
        ch = new int[n + 1];
        //거리배열
        dis = new int[n + 1];
        //인접리스트 값 대입
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        dis[1] = 0;
        //BFS 시작 (너비우선탐색)
        T.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
