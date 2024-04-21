package PrefixSum;

import java.io.*;
import java.util.*;

public class Example11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int k = 1; k <= n; k++) {
            arr[k] = Integer.parseInt(st.nextToken());
            arr[k] += arr[k-1];
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int answer = arr[j] - arr[i - 1];
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
