package section7;

import java.util.Scanner;

//재귀함수를 이용한 이진수 출력
public class ExampleTwo2 {
    public void solution(int n) {
        if(n==0) return;
        else{
            System.out.println(n%2 + " ");
            solution(n/2);
        }
    }

    public static void main(String[] args) {
        ExampleTwo2 T = new ExampleTwo2();
        T.solution(11);
    }
}
