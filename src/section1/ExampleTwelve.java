package section1;

import java.util.Scanner;

//암호
public class ExampleTwelve {
    public String solution(int n, String str) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            //#****###**#####**#####**##**라면 0번 부터 7번 인덱스 전까지 문자열을 뽑아냄
            //replace(a,b) : a 문자를 b문자로 변경 (문자열도 가능)
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            //Integer.parseInt(tmp, 2) : tmp 문자열이 2진수임을 명시하고, 이를 10진수로 변환
            int num = Integer.parseInt(tmp, 2);
            //10진수를 문자로 변경하여 아스키 코드로 나타냄
            answer += (char) num;
            //뽑아낸 이후 문자열을 str에 대입
            str = str.substring(7);

        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleTwelve T = new ExampleTwelve();
        Scanner kb = new Scanner(System.in);
        int number = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(number, str));
    }
}
