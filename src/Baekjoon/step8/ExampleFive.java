package Baekjoon.step8;

import java.io.*;

public class ExampleFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int visit = 1; // 방문 수 (최소로 주어질 수 있는 값으로 설정)
        int room = 2; // 최소 개수의 방 (1을 제외 한 최소로 주어질 수 있는 값으로 설정)

        if (n == 1) {
            System.out.println(1);
        } else {
            //room의 값이 점점 커질 수록 방문 수(visit)는 +1씩 증가하나 room이 입력받은 n보다 크게되면 방문 수(visit) 출력
            while (room <= n) {
                room = room + (visit * 6);
                visit++;
            }
            System.out.println(visit);
        }
    }
}
