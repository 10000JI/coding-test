package section1;

import java.util.Scanner;

//회문 문자열
class ExampleSeven {
    public String solution(String str){
        String answer = "NO";

        /**
         * (1) 문자배열의 인덱스 번호로 비교 ( length() / 2 사용 )
         */
//        str = str.toUpperCase();
//        int len = str.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (str.charAt(i) != str.charAt(len - i - 1)) {
//                answer = "NO"; // 이때 answer의 초기값은 "YES"로 되어있어야 함
//            }
//        }

        /**
         * (2) StringBuilder()의 reverse() 사용
         */
        String string = new StringBuilder(str).reverse().toString();
        //equalsIgnoreCase(): 대소문자 무시
        if (str.equalsIgnoreCase(string)) {
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleSeven T = new ExampleSeven();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
