package Baekjoon.step14;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ExampleFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map1 = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map1.containsKey(num)) {
                sb.append(map1.get(num)).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
