package section3;

import java.util.Scanner;

//연속 부분수열
public class ExampleFour {
    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            for (int j = i + 1; j < n; j++) {
                sum += arr[j];
                if (sum == m) {
                    answer++;
                    sum = 0;
                    break;
                } else if (sum > m) {
                    sum = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleFour T = new ExampleFour();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,m,arr));
    }
}
