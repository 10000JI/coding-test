package Baekjoon.step15;

import java.io.*;

public class ExampleEight {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 들어오는 입력마다 소수를 구하는 것보다는 한번에 모든 소수를 구해 꺼내쓰자
        // true: 소수x , false: 소수
        boolean[] arr = new boolean[1000001];
        arr[0] = arr[1] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    arr[j] = true;
                }
            }
        }

        //2. t번의 입력을 1~1000000 사이 숫자 중에 숫자인 값을 false로 저장한 arr를 이용하여 파티션이라면 count+1
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            //(3,7) (7,3) 이런 식으로 중복이 불가능하기 때문에 n/2까지 라는 조건을 줌

            for (int j = 2; j <= n / 2; j++) {
                if (!arr[j] && !arr[n - j]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
