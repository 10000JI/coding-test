package section7;

import java.util.Scanner;

//피보나치 수열
public class ExampleFour1 {
    public int solution(int n) {
        if(n == 1) return 1;
        else if (n == 2) return 1;
        else return solution(n - 1) + solution(n - 2);

    }


    public static void main(String[] args) {
        ExampleFour1 T = new ExampleFour1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int i=1;i<=n;i++) System.out.print(T.solution(i)+" ");
    }
}
