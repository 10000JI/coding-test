package section5;

import java.util.Scanner;
import java.util.Stack;

//괄호문자제거
public class ExampleTwo {
    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                if (x == ')') {
                    stack.pop();
                    continue;
                }
                if(stack.isEmpty()) answer += x;
            }
        }
        return answer;
    }
    public static void main(String args[]) {
        ExampleTwo T = new ExampleTwo();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
