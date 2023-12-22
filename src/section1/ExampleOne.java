package section1;

import java.util.Scanner;

//문자 찾기
//백준에선 class 이름이 Main (ExampleOne -> Main 변경 필요)
class ExampleOne {
    public int solution(String str, char t){
        int answer = 0;
        //대소문자 구분이 없으므로 입력된 문자열과 문자 모두 대문자로 변경
        str = str.toUpperCase();
        //t는 문자이기 때문에 Character 클래스의 메소드로 대문자 변경
        t = Character.toUpperCase(t);
        //System.out.println(str+" "+t);
        for (int i = 0; i < str.length(); i++) {
            //str 문자열을 0부터 str 길이까지의 인덱스번호로 접근
            if (str.charAt(i) == t)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        //ExampleOne 클래스의 solution 메서드가 인스턴스 메소드(none-static) 이기 때문에 객체 생성9
        ExampleOne T = new ExampleOne();
        Scanner kb = new Scanner(System.in);
        //next(): 콘솔창에서 문자열 하나를 읽음, String 형태
        String str = kb.next();
        //next().charAt(0): String을 인덱스로 접근하여 0번에 있는 것을 리턴
        char c = kb.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}
