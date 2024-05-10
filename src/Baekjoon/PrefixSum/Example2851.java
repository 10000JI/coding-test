package Baekjoon.PrefixSum;

import java.io.*;

public class Example2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[11];
        int sum = 0;

        //누적합 배열
        for (int i = 1; i < 11; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < 11; i++) {
            //합한 arr이 100인 숫자가 있다면 sum에 100대입
            if (arr[i] == 100) {
                sum = 100;
                break;
            }
            //100보다 크다면 100과 가까운 수 sum에 대입, 만약 100에 가까운 수가 2개라면 (예: 98, 102) 마리오는 큰 값을 선택
            else if (arr[i] > 100) {
                int a = arr[i] - 100;
                int b = 100 - arr[i - 1];
                if (a == b) {
                    sum = arr[i];
                    break;
                } else {
                    sum = (a > b) ? arr[i - 1] : arr[i];
                    break;
                }
            }
        }
        if (sum == 0) {
            sum = arr[10];
        }
        System.out.println(sum);
    }
}
