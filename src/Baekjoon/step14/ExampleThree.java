package Baekjoon.step14;

import java.io.*;
import java.util.*;
public class ExampleThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (!map.containsKey(name)) {
                map.put(name, st.nextToken());
            } else {
                map.replace(name, st.nextToken());
            }
        }
        List<String> list = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name).equals("enter")) {
                list.add(name);
            }
        }

        Collections.sort(list);

        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

}