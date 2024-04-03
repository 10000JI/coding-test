package Baekjoon.step13;

import java.io.*;
import java.util.*;

public class ExampleEleven {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int num : sortedArr) {
            if (!map.containsKey(num)) { //여기서 중복된 입력이 있다면 키가 이미 있다고 확인되어 넘어감
                map.put(num, idx++);
            }
        }

        for (int num : arr) {
            sb.append(map.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
