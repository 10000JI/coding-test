package section4;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

//K번째 큰 수
public class ExampleFive {
    public int solution(int n, int k, int[] arr) {
        //k번째 수가 존재하지 않으면 -1 출력
        int answer = -1;
        //기본 생성자로 만들면 오름차순이지만, Collections.reverseOrder()를 사용하면 내림차순
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for (int x : Tset) {
            //Set에 저장된 숫자가 for문이 돌 때마다 cnt++
            cnt++;
            //cnt가 k번째 수와 동일하면 Set에 내림차순으로 정렬된 k번째 수 리턴
            if (cnt == k) return x;
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleFive T = new ExampleFive();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, k, arr));
    }
}
