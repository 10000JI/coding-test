package Baekjoon.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExampleFour {

    public static void main(String[] args) throws IOException {
        /**
         * 1. StringBuilder의 reverse() 메서드 사용
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        String reversed = new StringBuilder(input).reverse().toString();
//        if (input.equals(reversed)) {
//            System.out.println(1);
//        } else {
//            System.out.println(0);
//        }
        /**
         * 2. 문자열을 문자 배열로 만든 후 while문을 돌려 뒤집기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        char[] chars = origin.toCharArray();
        int lt = 0, rt = origin.length() - 1;
        while (lt < rt) {
            char tmp = chars[lt];
            chars[lt] = chars[rt];
            chars[rt] = tmp;
            lt++;
            rt--;
        }
        if (origin.equals(String.valueOf(chars))) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
