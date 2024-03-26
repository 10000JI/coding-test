package Baekjoon.step8;

import java.io.*;
import java.util.*;

public class ExampleOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n =st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int tmp = 1;
        int sum = 0;

        //오른쪽부터 계산(지수가 0,1,2...)
        for (int i = n.length()-1; i >= 0; i--) {
            char c = n.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sum += (c - 'A' + 10) * tmp; //'a'은 아스키코드로 97
            } else {
                sum += (c - '0') * tmp; //'0'은 아스키코드로 48
            }
            tmp *= b;
        }
        System.out.println(sum);
    }
}
