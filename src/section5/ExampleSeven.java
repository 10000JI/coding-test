package section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//교육과정 설계
public class ExampleSeven {
    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for(char x : need.toCharArray()) queue.offer(x);
        for (char x : plan.toCharArray()) {
            if(queue.contains(x)) {
                //queue에 plan의 글자가 들어 있으나, 순서에 어긋난다면
               if(x != queue.poll()) return "NO";
            }
        }
        //queue에 문자들을 다 꺼내야 YES인데, 한 자라도 남아있다면 NO
        if(!queue.isEmpty()) return "NO";
        return answer;
    }
    public static void main(String[] args) {
        ExampleSeven T = new ExampleSeven();
        Scanner kb = new Scanner(System.in);
        String need = kb.next();
        String plan = kb.next();
        System.out.println(T.solution(need,plan));
    }
}
