package section2;

import java.util.Scanner;

//소수(에라토스테네스 체)
public class ExampleFive {

    public int solution(int n) {
        int answer = 0;
        //인덱스 번호가 n번 까지 생겨야 함
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            //이중 for문에서 ch[j]=1에 걸린 숫자는 if문에 들어오지 못함 -> 따라서 추후에 if문 실행이 안됨으로 소수를 담는 answer에 해당 X
            if (ch[i] == 0) {
                answer++;
                //j는 i의 배수로 for문 돌아야 함
                //이중 for문 j에서 걸리는 숫자들은 이전 숫자들 중 한개라도 배수에 들지 않음을 증명
                for (int j = i; j <= n; j = j + i) {
                    //i의 배수에 해당되는 숫자는 1을 대입
                    ch[j] = 1;
                }
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
