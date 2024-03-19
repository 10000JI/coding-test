package Baekjoon.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExampleFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //바구니에 들어있는 공의 번호를 알려줄 배열
        int[] answer = new int[n];
        //공을 총 m회 넣는다
        for (int i = 0; i < m; i++) {
            //a부터 b번까지의 바구니에 c인 공의 번호를 넣음
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int j = a; j <= b; j++) {
                //실제 배열은 0번 인덱스부터 시작 = 1번 바구니
                answer[j-1] = c;
            }
        }
        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}
