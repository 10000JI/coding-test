package Baekjoon.step15;

import java.io.*;
import java.util.*;

public class ExampleSix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1]; //1은 무조건 제외해야 함으로 무시하고 시작할 것. 따라서 인덱스가 뒤로 한칸 밀려남

        //배열 초기화
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        //2부터 시작해 i의 배수를 지운다
        for (int i = 2; i <= n; i++) {
            //이미 지워진 수는 건너뛴다
            if (arr[i] == 0) continue;
            for (int j = i * i; j <= n; j += i) {
                arr[j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n ;i++) {
            if (arr[i] != 0) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
