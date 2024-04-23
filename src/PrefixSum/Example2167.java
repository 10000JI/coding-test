package PrefixSum;

import java.io.*;
import java.util.*;

public class Example2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] s = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int h = 0; h < k; h++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            answer = s[x][y] - s[i - 1][y] - s[x][j - 1] + s[i - 1][j - 1];
            System.out.println(answer);

        }
    }
}
