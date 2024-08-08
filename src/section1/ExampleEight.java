package section1;

import java.util.Scanner;

//유효한 팰린드롬
public class ExampleEight {
    public String solution(String str) {
        String answer = "NO";
        //모두 대문자로 변경 후, 특수문자 모두 빼고 알파벳만 필터링
        //replaceAll(): replace() 와는 다르게 "정규식" 사용 가능, "[^A-Z]" 은 A-Z까지의 영문이 아닌 것들은 "" 빈문자로 변경해라
        //[^A-Z]: 대문자 A부터 Z가 아닌 모든 문자
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        //영대문자로 이루어진 str을 StringBuilder의 reverse() 메서드로 뒤집어 tmp 에 대입
        String tmp = new StringBuilder(str).reverse().toString();
        //뒤집어준 tmp와 뒤집기 전 str이 동일한 문자열이라면 answer는 "YES"
        if (tmp.equals(str)) {
            answer = "YES";
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleEight T = new ExampleEight();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
