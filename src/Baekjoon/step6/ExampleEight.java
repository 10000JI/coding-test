package Baekjoon.step6;

import java.io.*;

public class ExampleEight {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            //알파벳 26자, boolean 배열을 생성할 때 기본적으로 모든 요소의 초기값은 false
            boolean[] arr = new boolean[26];
            boolean check = true;

            for (int j = 0; j < str.length(); j++) {
                int ch = str.charAt(j) - 'a'; //int ch = str.charAt(j) - 97;
                //초기의 arr은 모두 false, 해당 if문을 통과하는 arr은 이미 앞에서 존재하였던 값
                if (arr[ch]) {
                    if (str.charAt(j) != str.charAt(j - 1)) {
                        check = false;
                        break;
                    }
                //처음 만나는 arr
                } else {
                    arr[ch] = true;
                }
            }

            // 해당 str은 조건에 만족
            if (check) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
