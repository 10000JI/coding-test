package Baekjoon.step16;

import java.io.*;
import java.util.*;

public class ExampleEight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    String str = st.nextToken();
                    q.offer(Integer.parseInt(str));
                    break;

                case "pop":
                    Integer item = q.poll();
                    if (item == null) {
                        sb.append(-1);
                    } else {
                        sb.append(item);
                    }
                    sb.append('\n');
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append('\n');
                    break;

                case "front":
                    Integer front = q.peek();
                    if (front == null) {
                        sb.append(-1);
                    } else {
                        sb.append(front);
                    }
                    sb.append('\n');
                    break;

                case "back":
                    Integer back = q.peekLast();
                    if (back == null) {
                        sb.append(-1);
                    } else {
                        sb.append(back);
                    }
                    sb.append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}
