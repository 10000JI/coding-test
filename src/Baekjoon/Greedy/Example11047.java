package Baekjoon.Greedy;

import java.io.*;
import java.util.*;

public class Example11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        Collections.reverse(arr);

        int cnt = 0;
        for (int coin : arr) {
            cnt += k / coin;
            k = k % coin;
        }

        System.out.println(cnt);
    }
}
