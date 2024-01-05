package section3;

import java.util.Scanner;

//연속된 자연수의 합 (경우의 수)
//연속 부분수열 과 유사!!
public class ExampleFive {
    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n / 2 + 1; //실제론 1부터 세지만 lt, for문의 i가 0으로 초기화 되어있기 때문에
        int[] arr = new int[m]; //정렬된 배열
        //arr에 대입한 후
        for (int i = 0; i < m; i++) arr[i] = i + 1;
        for (int rt = 0; rt < m; rt++) {
            //arr의 값을 조건에 맞게 sum에 대입
            sum += arr[rt];
            if (sum == n) answer++;
            while(sum>=n){
                sum -= arr[lt++];
                if(sum==n) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        ExampleFive T = new ExampleFive();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
