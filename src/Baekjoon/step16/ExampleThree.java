package Baekjoon.step16;

import java.io.*;
import java.util.*;

public class ExampleThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = "YES";
            Stack<Character> stack = new Stack<>();
            char[] chr = br.readLine().toCharArray();
            for (int j = 0; j < chr.length; j++) {
                if (chr[j] == '(') {
                    stack.push(chr[j]);
                } else {
                    if (stack.isEmpty()) {
                        answer[i] = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) answer[i] = "NO";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : answer) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
