package Baekjoon.step7;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleFour {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        //boolean 초기화 시 모든 배열 값이 false
        boolean[][] area = new boolean[101][101];
        int answer = 0;
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //입력받은 x값+10과 y값+10은 모두 true로 바꿔줌
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    area[j][k] = true;
                }
            }
        }

        //true인 부분은 +1
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (area[i][j]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
