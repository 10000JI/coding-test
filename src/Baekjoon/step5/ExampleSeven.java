package Baekjoon.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExampleSeven {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String p = st.nextToken();
            for (int j = 0; j < p.length(); j++) { // 문자열 p의 길이만큼 반복
                for (int k = 0; k < r; k++) { // 주어진 횟수만큼 반복하여 StringBuilder에 추가
                    sb.append(p.charAt(j));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


