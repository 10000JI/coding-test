package PrefixSum;

import java.util.*;
import java.io.*;

public class Example3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //동굴 길이
        int h = Integer.parseInt(st.nextToken()); //동굴 높이

        int[] down = new int[n / 2]; //석순
        int[] up = new int[n / 2]; //종유석
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            down[i] = a;
            up[i] = b;
        }
        //Binary Search(이진검색 알고리즘) : 미리 정렬
        Arrays.sort(up);
        Arrays.sort(down);
        int min = n; //파괴하는 장애물 최솟값
        int cnt = 0; //그 구간 수
//        for (int i = 1; i < h + 1; i++) {
//            int conflict =
//        }

    }

//    public int binarySearch(int left, int right, int h, int[] arr) {
//        while (left < right) {
//            int mid = (left + right) / 2;
//
//            if (arr[mid] >= h) {
//                right = mid;
//            }
//        }
//    }
}
