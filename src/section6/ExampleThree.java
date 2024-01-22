package section6;

import java.util.Scanner;

// 삽입 정렬
public class ExampleThree {
    public int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            //arr[i]가 정렬이 진행되면서 계속해서 값이 변경되므로 j의 for문이 돌기 전에 arr[i]를 tmp에 저장한다.
            //j는 for문이 끝난 후 tmp > arr[j] 순간에 tmp를 arr[j+1]에 대입해야 하므로 선언을 미리한다.
            int tmp = arr[i], j;
            //i번째보다 -1인 인덱스부터 0번 인덱스까지 값을 비교하는 for문
            for (j = i-1; j >= 0; j--) {
                //tmp > arr[j]라면 arr[j+1]에 arr[j] 대입
                if (tmp < arr[j]) arr[j + 1] = arr[j];
                //tmp > arr[j] 순간에 빠져나가고
                else break;
            }
            //arr[j+1] 에 tmp를 저장
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        ExampleThree T = new ExampleThree();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
