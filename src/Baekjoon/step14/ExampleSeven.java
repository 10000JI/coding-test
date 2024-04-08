package Baekjoon.step14;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ExampleSeven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashSet<Integer> set1 = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            set1.add(Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> set2 = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            set2.add(Integer.parseInt(st.nextToken()));
        }

        int countA = 0;
        for (Integer integer : set1) {
            if (set2.contains(integer)) {
                countA++;
            }
        }
        countA = set2.size() - countA;

        int countB = 0;
        for (Integer integer : set2) {
            if (set1.contains(integer)) {
                countB++;
            }
        }
        countB = set1.size() - countB;

        System.out.println(countA+countB);
    }
}
