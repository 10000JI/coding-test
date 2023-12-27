package section2;

import java.util.Scanner;

//점수계산
public class ExampleSeven {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                //누적
                answer += cnt;
            } else {
                //0이면 초기화
                cnt = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleSeven T = new ExampleSeven();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
