package section5;

import java.util.Scanner;
import java.util.Stack;

//괄호문자제거
public class ExampleTwo {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        /**
         * ** 내가 푼 코드
         * '('만나면 stack에 넣고, ')' 만나면 stack에서 삭제하되 continu를 써서 for문으로 올라온다.
         * 그리고 stack이 비어있다면 x를 answer에 추가한다.
         */
//        for (char x : str.toCharArray()) {
//            //'(' 문자라면 stack에 저장
//            if (x == '(') {
//                stack.push(x);
//            } else {
//                //')' 문자라면 stack에서 꺼내고 for문으로 다시 올라감
//                if (x == ')') {
//                    stack.pop();
//                    continue;
//                }
//                // stack에 '(' 문자가 저장된거 하나 없이 비어있다면 x 문자를 answer에 추가
//                if(stack.isEmpty()) answer += x;
//            }
//        }
        /**
         * ** 강의 코드
         * stack에 str 문자열을 문자배열로 바꿔 모두 push() 한다
         * 단, '('의 짝궁인 ')'을 만나는 순간엔 최근 저장한 문자부터 차례대로 '('를 만날때까지 pop()으로 삭제한다
         * stack에 저장된 나머지 문자들을 answer 문자열에 추가하여 리턴한다.
         */
        for (char x : str.toCharArray()) {
            if (x == ')') {
                //'(' 괄호가 아닐때까지 pop()으로 최근 저장한 문자부터 차례대로 삭제
                while(stack.pop()!='(');
            } else stack.push(x);
        }
        for(int i=0;i<stack.size();i++) answer+=stack.get(i);
        return answer;
    }
    public static void main(String args[]) {
        ExampleTwo T = new ExampleTwo();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
