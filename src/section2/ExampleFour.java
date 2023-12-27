package section2;

import java.util.Scanner;

//피보나치 수열
public class ExampleFour {
    public int[] solution(int n) {
        int[] anwser = new int[n];
        anwser[0] = 1;
        anwser[1] = 1;

        for (int i = 2; i < anwser.length; i++) {
            anwser[i] = anwser[i - 2] + anwser[i - 1];
        }

        return anwser;
    }

    public static void main(String[] args) {
        ExampleFour T = new ExampleFour();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for (int i : T.solution(n)) {
            System.out.print(i + " ");
        }
    }
}
