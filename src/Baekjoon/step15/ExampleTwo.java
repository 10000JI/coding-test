package Baekjoon.step15;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());
        System.out.println(LCM(a, b));
    }

    //최대공약수 ( 없으면 -1 을 반환 )
    public static Long GCD(Long a, Long b) {
        Long r = a % b;
        if (r == 0) {
            return b;
        } else if (r < 0) {
            return -1L;
        } else {
            return GCD(b, a % b);
        }
    }

    //최소공배수
    public static Long LCM(Long a, Long b) {
        Long gcd = GCD(a, b);
        if (gcd != -1) {
            return a * b / gcd;
        } else {
            return a * b;
        }
    }
}
