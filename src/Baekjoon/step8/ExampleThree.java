package Baekjoon.step8;

import java.io.*;
public class ExampleThree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] answer = new int[T][4];

        for (int i = 0; i < T; i++) {
            int money = Integer.parseInt(br.readLine());

            // 각 동전의 가치를 센트 단위로 표현
            int[] coinValues = {25, 10, 5, 1};

            for (int j = 0; j < 4; j++) {
                answer[i][j] = money / coinValues[j]; // 해당 동전의 개수 계산
                money %= coinValues[j]; // 사용한 동전의 금액 제거
            }
            sb.append(answer[i][0] + " " + answer[i][1] + " " + answer[i][2] + " " + answer[i][3]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
