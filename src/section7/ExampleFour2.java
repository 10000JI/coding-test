package section7;

import java.util.Scanner;

//피보나치 수열
public class ExampleFour2 {
    static int[] fibo;
    public int solution(int n) {
        //fibo의 인덱스 n의 값이 0보다 크다면 저장했음을 나타냄으로 해당 값을 리턴 -> 속도개선
        if(fibo[n]>0) return fibo[n];

        if(n == 1) return fibo[n]=1;
        else if (n == 2) return fibo[n]=1;
        else return fibo[n] = solution(n - 1) + solution(n - 2);

    }


    public static void main(String[] args) {
        ExampleFour2 T = new ExampleFour2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n + 1];
        T.solution(n);
        for(int i=1;i<=n;i++) System.out.print(fibo[i]+" ");
    }
}
