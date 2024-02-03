package section2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//가위 바위 보
public class ExampleThree {

    public String solution(int n, int[] a, int[] b) {
        String answer = "";
        /**
         * 1) a가 이기는 경우를 가정하여 조건문 완성
         */
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer += "D"; // a와 b가 비기는 경우
            } else if (a[i] == 1 && b[i] == 4) { //a가 가위(1)로 이김
                answer += "A";
            } else if (a[i] == 2 && b[i] == 1) { //a가 바위(2)로 이김
                answer += "A";
            } else if (a[i] == 4 && b[i] == 2) { //a가 보(4)로 이김
                answer += "A";
            } else {
                answer += "B"; //나머지는 모두 b가 이기는 경우
            }
        }
        return answer;

        /**
         * 2) a가 들어오는 수를 가정하여 중첩 if문 완성, 리턴이 List<String>
         */
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (a[i] == 1) {
//                if (b[i] == 2) {
//                    list.add("B");
//                } else if (b[i] == 4) {
//                    list.add("A");
//                } else {
//                    list.add("D");
//                }
//            } else if (a[i] == 2) {
//                if (b[i] == 1) {
//                    list.add("A");
//                } else if (b[i] == 4) {
//                    list.add("B");
//                } else {
//                    list.add("D");
//                }
//            } else if (a[i] == 4) {
//                if (b[i] == 1) {
//                    list.add("B");
//                } else if (b[i] == 2) {
//                    list.add("A");
//                } else {
//                    list.add("D");
//                }
//            }
//        }
//        return list;
    }

    public static void main(String[] args) {
        ExampleThree T = new ExampleThree();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = kb.nextInt();
        }
        for(char x : T.solution(n, a, b).toCharArray()) System.out.println(x);
    }
}
