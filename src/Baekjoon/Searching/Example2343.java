package Baekjoon.Searching;

import java.io.*;
import java.util.*;
public class Example2343 {

    static int rt, lt;
    static int[] arr;

    static int n, m;
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            rt += arr[i]; //arr의 모든 요소를 더한 값
            lt = Math.max(lt, arr[i]); //arr의 요소 중 가장 큰 값
        }
        binarySearch();

        System.out.println(lt);
    }

    static void binarySearch() {
        int mid, sum, count;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            sum = 0;
            count = 0;

            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += arr[i];
            }

            if(sum > 0) count++;

            if (count <= m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
    }

}
