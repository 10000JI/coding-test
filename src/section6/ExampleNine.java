package section6;

import java.util.Arrays;
import java.util.Scanner;

//뮤직비디오(결정알고리즘)
public class ExampleNine {
    public int count(int[] arr, int capacity) {
        //cnt: dvd 장수, sum: dvd에 담아내는 곡들의 크기
        int cnt = 1, sum = 0;
        for (int x : arr) {
            //sum과 arr의 인덱스들의 값을 더하는데 dvd 한장의 용량을 넘어가는 순간 ({1 2 3 4 5} 이후..)
            if (sum + x > capacity) {
                //새로운 장수가 필요함 (한 장은 이미 꽉 차고 두번째 장수를 채우는 것) ({6,7}로 채워가자)
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); //steam 리덕션
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2; //dvd 한장의 용량
            //dvd 몇 장으로 담을 수 있는가? 주어진 m장보다 작거나 같다면~
            if (count(arr, mid) <= m) {
                answer = mid; //dvd 한장의 용량을 리턴할 수 있게 answer에 담는다
                rt = mid - 1; // 더 좁혀 나가면서 mid를 설정한다
            }
            else lt = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleNine T = new ExampleNine();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,m,arr));
    }

}
