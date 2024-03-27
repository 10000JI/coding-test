package Baekjoon.step9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExampleFour {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            //1은 소수가 아니다.
            if (num == 1) {
                continue;
            }
            for (int j = 1; j <= num; j++) {
                if (num % j == 0) {
                    list.add(j);
                }
            }
            //소수: 1과 자기 자신만이 존재, 따라서 list 크기는 2여야 함
            if (list.size() == 2) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
