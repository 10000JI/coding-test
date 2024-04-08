package Baekjoon.step15;

import java.io.*;
import java.util.*;

public class ExampleThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //첫 번째 분자
        int b = Integer.parseInt(st.nextToken()); //첫 번째 분모

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken()); //두 번째 분자
        int d = Integer.parseInt(st.nextToken()); //두 번째 분모

        int numerator = a * d + b * c;
        int denominator = b * d;
        int mod = GCD(denominator, numerator);

        //계산이 끝난 분모 분자의 최대공약수가 없으면(mod가 -1) 그대로 출력
        //있다면 다음 if문 실행
        if (mod != -1) {
            numerator /= mod;
            denominator /= mod;
        }
        bw.write(numerator + " " + denominator);
        bw.flush();
        bw.close();

    }

    //최대공약수 ( 없으면 -1 을 반환 )
    public static int GCD(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        } else if (r < 0) {
            return -1;
        } else {
            return GCD(b, a % b);
        }
    }
}
