package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//등수 구하기
public class ExampleEight {

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    cnt++;
                }
                answer[i] = cnt;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        ExampleEight T = new ExampleEight();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int i : T.solution(n, arr)) {
            System.out.print(i+" ");
        }
    }
}
