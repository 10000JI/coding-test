package section7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//송아지 찾기 1(BFS : 상태트리탐색)
public class ExampleEight {
    //점프의 최소횟수
    int answer = 0;
    //한번 점프할 때 갈 수 있는 거리
    int[] dis = {1, -1, 5};
    //체크배열 생성
    int[] check;
    Queue<Integer> Q = new LinkedList<>();
    public int BFS(int s, int e) {
        //직선의 좌표 점은 1~10,000까지
        check = new int[10001];
        //출발지점 설정
        check[s] = 1;
        //출발지점 Q에 대입
        Q.offer(s);
        //L : level
        int L = 0;
        while (!Q.isEmpty()) {
            //각 레벨에 있는 원소의 개수
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                //해당 레벨에 Queue에서 꺼내 반환(삭제)
                int x = Q.poll();
                //원소 1개 당 dis인 1, -1, 5 이동하여 각 상황 비교
                for (int j = 0; j < 4; j++) {
                    //1, -1, 5씩 이동하여 nx 변수에 대입
                    int nx = x + dis[j];
                    //x(=송아지 위치)와 nx(=x에서 이동한 값)가 동일하면 L+1(=level+1) 리턴 -> Queue에 넣고 비교하는 것보다, 넣기 전에 비교하는게 훨씬 효율적
                    if(nx == e) return L+1;
                    //nx가 방문하지 않은 노드라면 (1~10,000 사이 좌표, check 배열에 해당 인덱스가 0인 숫자)
                    if (nx >= 1 && nx <= 10000 && check[nx] == 0) {
                        check[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            //level +1
            L++;
        }

        return answer;
    }


    public static void main(String[] args) {
        ExampleEight T = new ExampleEight();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}
