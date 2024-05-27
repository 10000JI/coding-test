package Baekjoon.Greedy;

import java.io.*;
import java.util.*;

public class Example1744 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num <= 0) {
                negative.add(num); //0을 포함한 음수
            }
            else {
                positive.add(num); //0보다 큰 양수
            }
        }

        while (!negative.isEmpty()) {
            int num = negative.poll();
            if (negative.isEmpty()) { //꺼낸 값 num이 마지막 값이면 더한 후 빠져나온다.
                answer += num;
                break;
            }
            if (negative.peek() == 0) { //이후에 꺼낸 값이 0일 때 꺼내버린다.
                negative.poll();
            } else { //0이 아니면 num과 곱한다.
                answer += num * negative.poll();
            }
        }

        while (!positive.isEmpty()) {
            int num = positive.poll();
            if (positive.isEmpty()) { //꺼낸 값 num이 마지막 값이면 더한 후 빠져나온다.
                answer += num;
                break;
            }
            if (num == 1) { //꺼낸 값 num이 1이면 answer에 더하기
                answer += 1;
            } else if (positive.peek() == 1) { //num이 1이 아니되, 이후에 꺼낸 값이 1이면 num과 더한다.
                answer += num + positive.poll();
            } else {
                answer += num * positive.poll(); //num이 1이 아니고, 이후에 꺼낸 값도 1이 아니면 num과 이후에 꺼낸 값을 곱한다.
            }
        }

        System.out.println(answer);
    }
}
