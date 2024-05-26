package Baekjoon.Greedy;

import java.io.*;
import java.util.*;

public class Example1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //List<Integer> arr = new ArrayList<>(); List 대신 우선순위 큐(PriorityQueue) 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (pq.size() > 1) {
            int n1 = pq.poll(); // poll은 꺼낸 후 삭제해버림
            int n2 = pq.poll();
            int sum = n1 + n2;
            answer += sum;
            pq.offer(sum); // 저장, 최종적으론 하나만 남음
        }

        System.out.println(answer);
    }
}
