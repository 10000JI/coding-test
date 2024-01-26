package section7;


import java.util.Scanner;

//재귀함수
public class ExampleOne {
    public void DFS(int n) {
        if(n==0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public void solution(int n) {
        DFS(n);
    }

    public static void main(String[] args) {
        ExampleOne T = new ExampleOne();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        T.solution(n);
    }
}
