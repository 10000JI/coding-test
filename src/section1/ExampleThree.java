package section1;

import java.util.Scanner;

// 문장 속 단어
class ExampleThree {
    public String solution(String str) {
        String answer = "";
        // m: 가장 긴 단어를 찾기 위한 변수
        // 최댓값을 저장해야 하므로 변수 선언 시에 가장 작은 숫자로 초기화
        int m = Integer.MIN_VALUE;
        // 띄어쓰기를 split()으로 각각의 단어를 구별
        String[] s = str.split(" ");
        for (String x : s) {
            //단어의 길이 추출
            int len = x.length();
            //해당 단어길이가 변수 m보다 큰 수라면 m에 len값을 대입하고, answer에 단어 교제
            if (len > m) {
                m = len;
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String args[]) {
        ExampleThree T = new ExampleThree();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
}
