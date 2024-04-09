package Baekjoon.step16;

import java.io.*;
import java.util.*;

public class ExampleNine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        //1이 앞에 나오게 됨
        for (int i =1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            //영원히 꺼내(삭제, 반환도 함)
            q.poll();
            //반환하여 뒤에 쌓기
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}
