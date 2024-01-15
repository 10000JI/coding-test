package section5;

import java.util.Scanner;
import java.util.Stack;

//올바른 괄호
public class ExampleOne {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            //'(' 여는 괄호를 만나면 stack에 저장
            if (x == '(') {
                stack.push(x);
            } else {
                //stack에 '(' 여는 괄호가 존재해야 ')' 닫는 괄호를 꺼낼 수 있는 조건이 충족되는데, 비어있다면 조건에 성립하지 않아 "NO"를 리턴
                if(stack.isEmpty()) return "NO";
                //')' 닫는 괄호를 만나면 stack에서 꺼냄
                stack.pop();
            }
        }
        //stack에 아직도 '(' 여는 괄호가 있다면 "NO"를 리턴
        if(!stack.isEmpty()) return "NO";
        return answer;
    }

    public static void main(String[] args) {
        ExampleOne T = new ExampleOne();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }

}
