package section2;

import java.util.Scanner;

//보이는 학생
public class ExampleTwo {

    public int solution(int n, int[] students) {
        int cnt = 1;
        int student = students[0];
        for (int i = 1; i < n; i++) {
            if (student < students[i]) {
                student = students[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ExampleTwo T = new ExampleTwo();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, students));
    }
}
