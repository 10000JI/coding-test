package section6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//선택 정렬
public class ExampleOne {
    public int[] solution(int n, int[] arr) {
        //굳이 마지막 배열 인덱스까지 for문 안돌려도 된다.
        //n-1번 인덱스까지 계산해도 마지막 배열 인덱스의 값은 제일 큰 수가 들어오기 때문
        for (int i = 0; i < n-1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) idx = j;
            }
            //i 인덱스 값보다 작은 값이 있었다면 idx 인덱스 번호가 변경 되었을 걸
            //i번 인덱스와 idx 인덱스 번호의 값의 위치를 서로 바꿔주는 작업
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        ExampleOne T = new ExampleOne();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x+" ");
        }
    }
}
