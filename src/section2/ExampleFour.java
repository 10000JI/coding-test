package section2;

import java.util.Scanner;

//피보나치 수열
public class ExampleFour {
    /**
     * 1) 배열을 사용하여 출력
     * */
//    public int[] solution(int n) {
//        int[] anwser = new int[n];
//        anwser[0] = 1;
//        anwser[1] = 1;
//
//        for (int i = 2; i < n; i++) {
//            anwser[i] = anwser[i - 2] + anwser[i - 1];
//        }
//
//        return anwser;
//    }

    /**
     * 2) 손코딩하여 출력
     */
    public void solution(int n) {
        int a=1, b=1, c;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        ExampleFour T = new ExampleFour();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        /**
         * 1) 배열을 사용하여 출력
         */
//        for (int i : T.solution(n)) {
//            System.out.print(i + " ");
//        }
        /**
         * 2) 손코딩하여 출력
         */
        T.solution(n);
    }
}
