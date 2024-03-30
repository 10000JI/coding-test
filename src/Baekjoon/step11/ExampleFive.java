package Baekjoon.step11;

import java.io.*;

public class ExampleFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값은 최대 크기가 500,000이므로 int형 써도 괜찮음
        int n = Integer.parseInt(br.readLine());
        //그러나 n * n * n 은 n의 최대 크기가 500,000이라는 가정 하에 계산하면 int형 보다 큰 값을 출력하므로 long으로 형변환
        long answer = (long) n * n * n;
        System.out.println(answer);
        System.out.println(3);
    }
}
