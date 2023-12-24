package section1;

import java.util.Scanner;

//숫자만 추출
public class ExampleNine {
    public int solution(String str) {

        /**
         * (1) 문자를 아스키 번호로 계산하여 실제 숫자 리턴
         */
//        int answer = 0;
//        for (char x : str.toCharArray()) {
//            // 아스키번호가 48부터 57 사이에 있으면 문자 '0'부터 '9'의 값
//            if (x >= 48 && x < 57) {
//                //문자로 연산하게 되면 아스키 번호로 연산하게 됨 ( ex> 문자 '0' = 아스키번호 48 )
//                //x애서 -48을 해야 실제 숫자값으로 반환, 곱하기 10은 자릿수 누적을 위해 사용
//                answer = answer * 10 + (x - 48);
//            }
//        }
//        return answer;

        /**
         * (2) 문자배열을 반복문 돌려, isDigit() 메소드를 이용해 문자 한 개씩 숫자인지 검증
         */
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        ExampleNine T = new ExampleNine();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
