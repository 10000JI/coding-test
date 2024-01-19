package section5;

import java.util.Scanner;
import java.util.Stack;

//쇠막대기
public class ExampleFive {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            //'('를 만나면 stack에 push()
            if(str.charAt(i) =='(') stack.push('(');
            else {
                //')'를 만나면 stack에서 pop()
                stack.pop();
                //'(' 이전 값이 ')' 이면 stack의 size를 answer에 추가
                if(str.charAt(i-1) == '(') answer += stack.size();
                //'(' 이전 값이 '(' 이면 answer에 1 추가
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleFive T = new ExampleFive();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
