package Baekjoon.step16;

import java.io.*;
import java.util.*;

public class ExampleFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (true) {
            str = br.readLine();
            if (str.equals(".")) break;
            else System.out.println(solution(str));
        }
    }

    public static String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            if (chr == '(' || chr == '[') stack.push(chr);
            else if (chr == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return "no";
                else stack.pop();
            } else if (chr == ']') {
                if(stack.isEmpty() || stack.peek() != '[') return "no";
                else stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
