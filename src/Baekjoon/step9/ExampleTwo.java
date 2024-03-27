package Baekjoon.step9;

import java.io.*;
import java.util.*;

public class ExampleTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            //나누어 떨어지는 것이 인증 되었으므로 약수이다.
            if (n % i == 0) {
                list.add(i);
            }
        }
        if (list.size() >= k) {
            System.out.println(list.get(k-1));
        } else {
            System.out.println(0);
        }
    }
}
