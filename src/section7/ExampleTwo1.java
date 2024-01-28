package section7;

import java.util.Scanner;

//재귀함수를 이용한 이진수 출력
public class ExampleTwo1 {
    public String solution(int n, String answer) {
        int a = 0, b = 0;
        if (n != 1) {
            a = n / 2;
        }
        b = n % 2;
        answer += b;
        if (n == 1) {
            answer = new StringBuilder(answer).reverse().toString();
            return answer;
        }
        a = n / 2;
        return solution(a,answer);
    }

    public static void main(String[] args) {
        ExampleTwo1 T = new ExampleTwo1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n,""));
    }
}
