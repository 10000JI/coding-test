package section1;

import java.util.Scanner;

// 문장 속 단어
class ExampleThree {
    public String solution(String str) {
        String answer = "";
        // m: 가장 긴 단어를 찾기 위한 변수
        // 최댓값을 저장해야 하므로 변수 선언 시에 가장 작은 숫자로 초기화
        int m = Integer.MIN_VALUE, pos;

        /**
         * (1) 띄어쓰기를 split()으로 각각의 단어를 구별
         */
//        String[] s = str.split(" ");
//        for (String x : s) {
//            //단어의 길이 추출
//            int len = x.length();
//            //해당 단어길이가 변수 m보다 큰 수라면 m에 len값을 대입하고, answer에 단어 교제
//            if (len > m) {
//                m = len;
//                answer = x;
//            }
//        }
//        return answer;

        /**
         * (2) indexOf()로 띄어쓰기를 발견하지 못하였다면 -1를 리턴, 발견한다면 해당 인덱스 번호 리턴
         */
        //indexOf() : 제공하는 문자 또는 문자열의 인덱스 번호 반환, 없으면 -1 반환
        while ((pos = str.indexOf(" ")) != -1) {
            //substring(0, x) : 0부터 x-1까지 String 문자열을 자른다.
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            //"len이 m보다 크다"로 설정하는 이유는 문장속에서 가장 앞쪽에 위치한 단어를 답으로 해야되기 때문
            if (len > m) {
                m = len;
                answer = tmp;
            }
            //"it is time to study" 문자열에서 "It "를 초기에 indextOf()로 pos = 3 을 리턴받았으므로,
            // pos + 1 하여 인덱스 번호 4부터 subString()하여 "is time to study"을 str에 대입
            str = str.substring(pos + 1);
        }
        //마지막 단어 "study"일 때는 while의 조건문을 적용했을 때 공백이 없으므로 while문이 종료
        //따라서 마지막 단어의 길이가 m보다 큰 수라면 answer에 대입해주는 과정이 필요
        if (str.length() > m) {
            answer = str;
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
