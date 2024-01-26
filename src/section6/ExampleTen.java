package section6;

import java.util.Arrays;
import java.util.Scanner;

//마구간 정하기(결정알고리즘)
public class ExampleTen {

    public int count(int[] arr, int mid) {
        int cnt = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //현재 마구간의 좌표 - 직전에 지정한 마구간의 좌표
            if (arr[i] - ep >= mid) {
                cnt++;
                ep = arr[i];
            }
        }
        return cnt;
    }

    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        //두 말 사이의 거리이므로 제일 짧은 간격은 1일 것
        int lt = 1;
        //두 말 사이의 거리이므로 가장 긴 간격은 arr의 마지막 숫자
        int rt = arr[n - 1];
        while (rt >= lt) {
            //가장 가까운 두 말의 최대 거리
            int mid = (rt + lt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleTen T = new ExampleTen();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, c, arr));
    }

}
