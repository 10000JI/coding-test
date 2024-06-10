package Baekjoon.Graph;

import java.io.*;
import java.util.*;

public class Example1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        //그래프 이차원 리스트
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        //특정 건물을 지을 때, 먼저 지어져야 할 건물 개수 (=진입차수 저장 배열)
        int[] indegree = new int[n + 1];
        //특정 건물을 지을 때, 걸리는 시간
        int[] time = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                } else {
                    list.get(num).add(i);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
            }
        }

        //각 건물이 완성되기까지 걸리는 최소 시간
        int[] result = new int[n + 1];
        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                indegree[next]--;
                // next 건물을 짓기 전까지 걸린 시간 계산
                result[next] = Math.max(result[next], result[now] + time[now]);
                if (indegree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        //위에서 next 건물 짓기 전까지 걸린 시간을 계산하였으니, next 건물이 지어진 후 걸린 시간까지 계산하여 출력
        for (int i = 1; i <= n; i++) {
            sb.append(result[i] + time[i]).append("\n");
        }

        System.out.println(sb);
    }
}
