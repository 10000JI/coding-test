package Baekjoon.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ExampleFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : str.toCharArray()) {
            if (Character.isAlphabetic(x)) { // 알파벳인 경우에만 처리
                //Object getOrDefault(Object key, Object defaultValue) : 매개변수로 가져온 key가 없을 때 defaultValue(=지정된 값) 반환
                map.put(x, map.getOrDefault(x, 1) + 1);
            }
        }

        int max = 0;
        char answer = '?';

        for (char key : map.keySet()) {
            int count = map.get(key);
            if (count > max) {
                max = count;
                answer = key;
            } else if (count == max) { // 최대 빈도수가 여러 개인 경우
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
