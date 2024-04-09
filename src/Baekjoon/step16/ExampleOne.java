package Baekjoon.step16;

import java.io.*;
import java.util.*;
public class ExampleOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            if (num1 == 1) {
                int num2 = Integer.parseInt(st.nextToken());
                stack.push(num2);
            } else if (num1 == 2) {
                if (!stack.isEmpty()) {
                    int num2 = (int) stack.pop();
                    sb.append(num2).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (num1 == 3) {
                sb.append(stack.size()).append("\n");
            } else if (num1 == 4) {
                if (stack.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (num1 == 5) {
                if (!stack.isEmpty()) {
                    int num2 = (int) stack.peek();
                    sb.append(num2).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
