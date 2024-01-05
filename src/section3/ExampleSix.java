package section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//최대 길이 연속부분수열
public class ExampleSix {
    public int solution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0; //left
        //right
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) cnt++;
            //cnt는 k보다 크면 안된다.
            while (cnt > k) {
               //lt 인덱스 값이 0이되면 cnt는 -1
               if(arr[lt] == 0) cnt--;
               //if문을 만날 때까지 lt를 증가
               lt++;
            }
            //최종 1이 연속된 길이는 마지막에 대입시켜준다.
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        ExampleSix T = new ExampleSix();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,k,arr));
    }
}
