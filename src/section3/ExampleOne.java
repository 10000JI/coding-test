package section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 두 배열 합치기
public class ExampleOne {

    public List<Integer> solution(int n, int m, int[] a, int[] b) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        //p1이 n과 동일한 숫자가 되거나, p2가 m과 동일한 숫자가 되면 while문 빠져나감
        while (p1 < n && p2 < m) {
            //후위연산자, add 한 후 p1값 1증가
            if (a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        //p1이 아직 n보다 작은 상태
        while(p1<n) answer.add(a[p1++]);
        //p2가 아직 m보다 작은 상태
        while(p2<m) answer.add(b[p2++]);
        return answer;
    }

    public static void main(String[] args) {
        ExampleOne T = new ExampleOne();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }

        for (int x : T.solution(n, m, a, b)) System.out.print(x + " ");
    }
}
