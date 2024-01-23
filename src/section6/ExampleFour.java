package section6;

import java.util.Scanner;

//Least Recently Used
public class ExampleFour {
    public int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for (int x : arr) {
            int pos = -1; //pos: 인덱스 번호(position)
            for (int i = 0; i < s; i++) {
                //x값이 cache[i]값과 같다면 cache hit 라는 것 -> hit된 지점 pos에 저장
                if(x==cache[i]) pos = i;
            }
            //cache miss 일 때
            if (pos == -1) {
                //인덱스 번호 4번부터 1번까지 값 들어올 때마다 위치 +1씩 해서 옮기기
                for (int i = s - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } // cache hit 일 때
            else {
                for (int i = pos; i >= 1; i--) { //pos 지점부터 (=hit된 지점)
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }

    public static void main(String[] args) {
        ExampleFour T = new ExampleFour();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(s, n, arr)) {
            System.out.print(x+ " ");
        }

    }
}
