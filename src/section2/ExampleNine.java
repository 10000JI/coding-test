package section2;

import java.util.Scanner;

//등수 구하기
public class ExampleNine {

    public int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                //행끼리
                sum1 += arr[i][j];
                //열끼리
                sum2 += arr[j][i];
            }
            answer = Math.max(sum1, answer);
            answer = Math.max(sum2, answer);
        }
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i]; //좌측부터 우측으로 내려가는 대각선
            sum2 += arr[i][n-1-i]; //우측부터 좌측으로 내려가는 대각선
        }
        answer = Math.max(sum1, answer);
        answer = Math.max(sum2, answer);
        return answer;
    }
    public static void main(String[] args) {
        ExampleNine T = new ExampleNine();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
