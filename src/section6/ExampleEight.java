package section6;

import java.util.Arrays;
import java.util.Scanner;

//이분검색
public class ExampleEight {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt =0, rt = n-1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            //1. mid(중간) 값이 m과 같을때
            if (arr[mid] == m) {
                //answer는 0번 인덱스가 곧 1로 count
                answer = mid + 1;
                break;
            }
            //2. mid(중간) 값이 m보다 클 때
            else if (arr[mid] > m) {
                rt = mid-1;
            }
            //3. mid(중간) 값이 m보다 작을 때
            else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleEight T = new ExampleEight();
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
