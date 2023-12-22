package section1;

import java.util.Scanner;

//대소문자 변환
public class ExampleTwo {
    public String solution(String string) {
        String answer = "";
        for (char x : string.toCharArray()) {
//            // 방법1) 아스키코드로 접근
//            if (x >= 65 && x <= 90) {
//                //대문자일때 -> 소문자로 변환
//                answer += (char) (x + 32);
//            } else if (x >= 97 && x <= 122) {
//                //소문자일때 -> 대문자로 변환
//                answer += (char) (x - 32);
//            } // else 써도 무관

            // 방법2) x가 소문자라면
            if (Character.isLowerCase(x)) {
                //x를 대문자로 변환
                answer += Character.toUpperCase(x);
            } else {
                //x가 대문자라면 x를 소문자로 변환
                answer += Character.toLowerCase(x);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleTwo T = new ExampleTwo();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
