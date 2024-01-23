package section6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//장난꾸러기
public class ExampleSix {
    /**
     * 정렬을 했을 때 쉽게 풀리는 문제
     */
    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i+1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleSix T = new ExampleSix();
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
