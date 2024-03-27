package Baekjoon.step9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExampleThree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) {
                break;
            }

            List<Integer> list = new ArrayList<>();
            int sum = 0;

            //주의할 점은 num을 for문에 포함시키면 안된다.
            //문제에서 자기 자신을 제외한 모든 약수들의 합이라고 명시
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    list.add(i);
                    sum += i;
                }
            }
            if (sum == num) {
                sb.append(num).append(" = ");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i != list.size() - 1) {
                        sb.append(" + ");
                    }
                }
                sb.append("\n");
            } else {
                sb.append(num).append(" is NOT perfect.\n");
            }
        }
        System.out.println(sb.toString());
    }
}
