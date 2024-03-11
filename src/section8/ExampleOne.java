package section8;

import java.util.Scanner;

//합이 같은 부분집합(DFS : 아마존 인터뷰)
public class ExampleOne {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr) {
        //flag가 true이면 넘어오는 재귀함수(DFS)는 리턴시킴
        if(flag) return;
        //sum이 total의 반보다 커져버리면 재귀함수(DFS)는 리턴시킴
        if(sum>total/2) return;
        //L이 6이 되면 전체 부분집합이 완성되는 것
        //맨 위 루트에서 시작한 가지들이 L이 6이 될때까지 DFS, But 위 조건들에 해당하면 그전에 리턴당함
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                //flag를 true로 만들어버림
                flag = true;
            }
        }
        else{
            //SUM에 해당 레벨을 포함시켜 인덱스 배열을 추가
            DFS(L + 1, sum + arr[L], arr);
            //SUM에 해당 레벨을 포함시키지 않음
            DFS(L + 1, sum, arr);
        }
    }


    public static void main(String[] args) {
        ExampleOne T = new ExampleOne();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
