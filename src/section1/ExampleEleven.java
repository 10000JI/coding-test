package section1;

import java.util.Scanner;

//문자열 압축
public class ExampleEleven {
    public String solution(String str) {
        String answer = "";
        // 같은 문자가 연속으로 반복되는 경우 문자 바로 오른쪽에 반복 횟수 표기를 위해서 cnt 선언 및 초기화
        int cnt = 1;
        // str.charAt(str.length()) : 마지막 인덱스 번호 + 1 의 값이 존재하지 않아 if문에서 에러가 발생하므로 빈문자 추가
        str = str + " ";
        // str의 인덱스 번호 1개가 추가되었으므로 범위를 -1 좁혀즘
        for (int i = 0; i < str.length() - 1; i++) {
            // 현배 i번호 인덱스 값과 i+1번호 인덱스 값이 같다면
            if (str.charAt(i) == str.charAt(i + 1)) {
                // cnt 1 증가
                cnt++;
            } else {
                // 같지 않다면 answer에 i 인덱스 문자 값 추가
                answer += str.charAt(i);
                // cnt가 1보다 크면 문자 값 뒤에 cnt를 붙여줌
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    // cnt 초기화
                    cnt = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleEleven T = new ExampleEleven();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
