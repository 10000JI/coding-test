package Baekjoon.step13;

import java.io.*;
import java.util.*;
public class ExampleNine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> tree = new TreeSet<>((a,b)->{
            if (a.length() == b.length()) {
                return a.compareTo(b); //동일한 길이라면 사전 순으로 정렬
            }
            return a.length() - b.length(); //길이가 짧은 것부터 정렬
        });

        for (int i = 0; i < n; i++) {
            tree.add(br.readLine());
        }

        for (String answer : tree) {
            System.out.println(answer);
        }

    }
}
