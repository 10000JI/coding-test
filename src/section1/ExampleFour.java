package section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//특정 문자 뒤집기
class ExampleFour {
    public List<String> solution(String[] strings){
        List<String> answer = new ArrayList<>();

        /**
         * (1) StringBuilder 사용
         */
//        //"string" 문자열을 StringBuilder 객체 생성 후 reverse()로 뒤집은 뒤 toString()으로 문자열로 리턴
//        for (String string : strings) {
//            //StringBuiler를 쓰는 이유 : String으로 객체를 만들어 값을 만들어 놓으면 변경할 수 없음 (불변)
//            //따라서 String으로 만든 객체를 계속 대입하여 새로운 값으로 변경하면 새로운 객체로 만들어지는 문제점 발생
//            //StringBuilder를 쓰면 값을 계속 변경해도 한 개의 객체를 가지고 계속해서 사용 가능
//            String s =  new StringBuilder(string).reverse().toString();
//            answer.add(s);
//        }

        /**
         * (2) 직접 코드로 뒤집기
         */
        for (String string : strings) {
            //"string" 문자열을 문자배열로 만듦
            char[] s = string.toCharArray();
            //lt: 문자배열의 첫번째 인덱스, rt: 문자배열의 마지막 인덱스
            int lt = 0, rt = string.length() - 1;
            while (lt < rt) {
                //가변문자 tmp를 생성하여 운반 역할, 첫번째 인덱스 값 tmp에 대입
                char tmp = s[lt];
                //마지막 인덱스 값을 첫번째 인덱스 값에 대입
                s[lt] = s[rt];
                //tmp 값을 마지막 인덱스 값에 대입 => 첫번째 인덱스 값을 대입하는 것과 동일
                s[rt] = tmp;
                //첫번째 인덱스 + 1
                lt++;
                //마지막 인덱스 - 1
                rt--;
            }
            //valueOf()는 위 메서드들과는 다르게 static으로 선언된 클래스 메서드인 점 주의
            //문자를 문자열로 변경
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        //특정 단어만 뒤집으라고 할 수 있다 -> 이땐 모든 문자열을 뒤집는 StringBuilder의 reverse() 사용 불가능
        return answer;
    }

    public static void main(String[] args) {
        ExampleFour T = new ExampleFour();
        Scanner kb = new Scanner(System.in);
        int number = kb.nextInt();
        String[] strings = new String[number]; //배열 본체 생성 후 본체에 대한 참조 생성
        for (int i = 0; i < number; i++) {
            strings[i] = kb.next();
        }
        for (String s : T.solution(strings)) {
            System.out.println(s);
        }
    }
}
