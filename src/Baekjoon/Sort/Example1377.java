package Baekjoon.Sort;

import java.io.*;
import java.util.*;

// 재풀이
class Data implements Comparable<Data> {
    int value;
    int index;

    public Data(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Data o) {
        return this.value - o.value;
    }
}
public class Example1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] arr = new Data[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }
        br.close();
        Arrays.sort(arr);
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
}