package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//큰 수 출력하기
public class ExampleOne {
    public List<Integer> solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        //첫 번째 수는 무조건 출력
        list.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        return list;
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
            System.out.print(x + " ");
        }
    }
}
