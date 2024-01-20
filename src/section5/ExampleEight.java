package section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//응급실
class Person{
    int id; //처음 대기목록 상에서 순서번호
    int priority; //위험도
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class ExampleEight {
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //초기 대기열을 Person 객체로 queue에 저장
            queue.offer(new Person(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            //queue에 저장된 맨 앞의 Person을 꺼내 tmp에 저장 (queue에선 삭제됨)
            Person tmp = queue.poll();
            //맨 앞의 Person을 꺼내고 난 나머지 queue를 반복문 돌림
            for (Person x : queue) {
                //queue의 요소를 반복문 돌리면서 tmp보다 큰 priority가 발견되면 tmp를 다시 queue 뒤에 저장
                if (x.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            //반복문 돌리는 동안 tmp의 priority보다 큰 priority가 queue에 없기에
            //tmp가 대기열 중 가장 큰 숫자(위험도가 가장 높은)이므로 answer에 +1 한다.
            //만약 tmp의 id가 m번째 환자의 숫자와 같다면 answer를 리턴
            if (tmp != null) {
                answer++;
                if(tmp.id == m) return answer;
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        ExampleEight T = new ExampleEight();
        Scanner kb = new Scanner(System.in);
        //대기 목록에 있는 환자수
        int n = kb.nextInt();
        //m번째 환자
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,m,arr));
    }
}
