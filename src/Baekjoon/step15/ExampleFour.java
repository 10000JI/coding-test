package Baekjoon.step15;

import java.io.*;
import java.util.*;

public class ExampleFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int gcd = 0;
        for (int i = 0; i < n - 1; i++) {
            int dist = arr[i + 1] - arr[i];
            gcd = GCD(dist, gcd);
        }
        System.out.println((arr[n - 1] - arr[0]) / gcd);
        System.out.println(((arr[n - 1] - arr[0]) / gcd) + 1 - arr.length);
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
}
