package Baekjoon.Greedy;

import java.io.*;
import java.util.*;

public class Example1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { //회의 끝나는 시간이 같다면
                    return o1[0] - o2[0]; //회의 시작 시간 빠른순 정렬
                } else {
                    return o1[1] - o2[1]; //같지 않으면 회의 끝나는 시간 빠른순 정렬
                }
            }
        });

        int cnt = 1; // 하단에 첫번째 회의를 이미 count 함
        int min = arr[0][1]; // 정렬한 배열에서 첫번째 회의 끝나는 시간
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= min) { // 다음 회의 시작 시간이 회의 첫번째 회의 끝나는 시간보다 크거나 같다면
                min = arr[i][1]; // 회의 끝나는 시간 다시 세팅
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
