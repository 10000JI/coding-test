package section5;


import java.util.Scanner;
import java.util.Stack;

//후위식 연산(postfix)
public class ExampleFour {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            //Character.isDigit(x) : x가 숫자이면 true, 아니면 false
            if (Character.isDigit(x)) {
                //x는 현자 문자이다.
                //하지만 stack에 넣을 수 있는건 Integer이기 때문에 변환해주는 작업이 필요하다.
                //'5' 문자 5는 아스키코드로 숫자로 변환했을 때 54이기 때문에 x-48=5가 나오므로 문자 x에서 48을 뺀다.
                stack.push(x - 48);
            } else {
                //x가 문자가 아니라면 연산자를 만난 상황
                //pop()으로 삭제하면서 rt, lt에 해당 값을 저장
                int rt = stack.pop();
                int lt = stack.pop();
                if(x=='+') stack.push(lt + rt);
                else if (x=='-') stack.push(lt - rt);
                else if (x=='*') stack.push(lt * rt);
                else if (x=='/') stack.push(lt / rt);
            }
        }
        answer = stack.peek();
        //answer = stack.get(0);
        return answer;
    }

    public static void main(String[] args) {
        ExampleFour T = new ExampleFour();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}

