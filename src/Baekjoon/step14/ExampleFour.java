package Baekjoon.step14;

import java.io.*;
import java.util.*;
public class ExampleFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, i + 1);
            list.add(s);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) {
                sb.append(list.get(Integer.parseInt(s)-1)).append("\n");
            } else {
                sb.append(map.get(s)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
