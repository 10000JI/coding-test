package Baekjoon.step14;

import java.io.*;
import java.text.CollationKey;
import java.util.*;

public class ExampleSix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                list.add(s);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
