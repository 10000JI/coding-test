package Baekjoon.step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값은 최대 크기가 500,000이므로 int형 써도 괜찮음
        int n = Integer.parseInt(br.readLine());
        //그러나 n * n 은 n의 최대 크기가 500,000이라는 가정 하에 계산하면 250,000,000,000이기 때문에 long 형으로 바꿔줘야 함
        long answer = (long) n * n;
        System.out.println(answer);
        System.out.println(2);
    }
}
