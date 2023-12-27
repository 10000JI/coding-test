package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//뒤집은 소수
public class ExampleSix {

    public boolean isPrime(int num){
        //1은 소수가 아님
        if (num == 1) {
            return false;
        }
        //1 건너뛰고 2부터 num 전까지 num이 소수인지 확인
        //num보다 작은 수들을 나눴을때 나머지가 0 이면(=약수 발견) 소수 X
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10; //나머지
                res = res * 10 + t;
                tmp = tmp / 10; //몫
            }
            if (isPrime(res)) {
                list.add(res);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ExampleSix T = new ExampleSix();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, arr)) {
            System.out.print(x+" ");
        }
    }
}
