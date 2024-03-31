package Baekjoon.step12;

import java.io.*;

public class ExampleTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            int sum = i, generator = i; // sum: 분해합, generator: 생성자
            while (generator != 0) {
                sum += (generator % 10); //generator(=i)가 198로 들어왔다면 : 198 % 10 = 8, 19 % 10 = 9, 1 % 10 = 1  --> sum = 198+8+9+1=216
                generator = generator / 10; // 198/10 = 19 , 19/10=1
            }
            if (sum == n) { //입력한 분해합과 도출된 분해합이 동일하면 종료
                sb.append(i);
                System.out.println(sb);
                return;
            }
        }
        sb.append(0);
        System.out.println(sb);
    }
}
