package section1;

import java.util.Scanner;

//가장 짧은 문자거리
public class ExampleTen {
    public int[] solution(String str, char t) {
        // answer: 문자열 str의 각 문자가 문자 t와 떨어진 거리를 int 배열로 str 문자 인덱스 수 만큼 생성
        int[] answer = new int[str.length()];
        // p: 거리, 초기값은 아주 크게 놓고 시작 (문자와 문자 사이 거리는 100을 넘지 않는 것을 명심)
        int p = 1000;
        // 배열 answer 좌->우 for문
        for (int i = 0; i < str.length(); i++) {
            // str의 문자 한 개가 문자 t와 동일한 문자라면 p=0 으로 변경하고 answer의 인덱스 번호의 값을 0으로 함
            if (str.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        // 배열 answer 우->좌 for문
        for (int i = str.length()-1; i >= 0; i--) {
            if (str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                // Math.min(a,b): 기존 값(=a)과 p(=b) 중에서 작은 값을 넣어줌
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleTen T = new ExampleTen();
        Scanner kb = new Scanner(System.in);
        // 문자열 입력
        String str = kb.next();
        // 문자 한개 입력
        char c = kb.next().charAt(0);
        for (int x : T.solution(str, c)) {
            System.out.print(x+" ");
        }
    }
}
