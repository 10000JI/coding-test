package section7;

import java.util.Scanner;

//팩토리얼
public class ExampleThree {
    public int solution(int n) {
        if(n==1) return 1;
        else {
           return n * solution(n-1);
        }
    }

    public static void main(String[] args) {
        ExampleThree T = new ExampleThree();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
