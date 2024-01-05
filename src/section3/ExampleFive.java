package section3;

import java.util.Scanner;

//연속된 자연수의 합 (경우의 수)
public class ExampleFive {
    public int solution(int n) {
        int answer = 0, cnt = 1;
        //n이 15라면 14로 -1
        n--;
        while (n > 0) {
            //첫번째 while문에서 cnt가 2로 증가
            cnt++;
            //14인 n은 -2하여 12가 된다 (=while문 전에 1빼고, while문 안에서 2를 뺐다.)
            n=n-cnt;
            //n이 cnt로 나눴을때 나머지가 0이라는 것은 "연속된 자연수가 15가 된다는 것"
            if (n % cnt == 0) {
                answer++;
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
