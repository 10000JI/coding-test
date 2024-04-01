package Baekjoon.step12;

import java.io.*;

public class ExampleFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 초기 종말의 수는 666부터 시작
        int count = 0; // 종말의 수를 세는 변수
        int num = 666; // 현재 검사하는 수

        // 입력된 숫자에 해당하는 종말의 수를 찾을 때까지 반복
        while (true) {
            // 현재 수에 "666"이 포함되어 있는지 확인
            if (String.valueOf(num).contains("666")) {
                count++; // 종말의 수 발견

                // 찾고자 하는 종말의 수인지 확인
                if (count == n) {
                    // 찾았으면 해당 종말의 수를 출력 후 종료
                    System.out.println(num);
                    break;
                }
            }
            // 다음 수 검사
            num++;
        }
    }
}