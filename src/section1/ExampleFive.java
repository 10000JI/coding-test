package section1;

import java.util.Scanner;

//특정 문자 뒤집기
class ExampleFive {
    public String solution(String str) {
        char[] charArray = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            //문자배열의 0번 인덱스의 값이 알파벳이 아닐 때 참
            if (!Character.isAlphabetic(charArray[lt])) lt++;
            //문자배열의 0번 인덱스의 값이 알파벳이 아닐 때 참
            else if (!Character.isAlphabetic(charArray[rt])) rt--;
            else{
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
        }
        String answer = String.valueOf(charArray);
        return answer;
    }

    public static void main(String[] args) {
        ExampleFive T = new ExampleFive();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}
