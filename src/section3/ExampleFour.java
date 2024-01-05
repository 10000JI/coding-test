package section3;

import java.util.Scanner;

//연속 부분수열
public class ExampleFour {
    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            //여기서 sum은 lt부터 rt까지의 합이다.(최초 rt와 lt는 동일 인덱스 번호이기 때문)
            if(sum==m) answer++;
            //lt는 sum이 m보다 크거나 같을때 인덱스의 값을 sum에서 빼고, 인덱스 번호를 +1한다.
            /**
             * ex >만약 배열이 1 1 1 1 5라고 가정했을 때, sum은 9이다. lt의 0번 인덱스 값을 빼면 sum은 8이 되고, lt 인덱스 번호는 1번이다.
             *     여전히 sum은 8로 6보다 크므로 lt 값을 빼고, 인덱스 번호를 +1 해주는 작업을 반복해야 된다.
             *     그러므로 lt를 변경하는 작업을 여러번 할 수 있으므로 while문을 작성해야 한다.
             *
             */
            while (sum >= m) {
                //lt는 후위연산자
                sum -= arr[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleFour T = new ExampleFour();
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
