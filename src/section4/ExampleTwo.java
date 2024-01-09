package section4;

import java.util.HashMap;
import java.util.Scanner;

//아나그램(해쉬)
public class ExampleTwo {
    public String solution(String arr1, String arr2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        //map에 arr1의 문자열의 문자들와 해당 문자들의 개수를 담았다.
        for (char x : arr1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : arr2.toCharArray()) {
            /**
             * if문 : 아나그램이 아닌 상황
             */
            //key가 존재하는지 (t/f) 존재하면 t를 반환하므로 ! 를 앞에 붙여준다
            //key의 값이 0 : arr2에 key가 존재하는데도 불구하고 arr2은 arr1(=x)의 문자열의 문자보다 1개 더 많다는 뜻
            if (!map.containsKey(x) || map.get(x) == 0)  return "NO";
            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleTwo T = new ExampleTwo();
        Scanner kb = new Scanner(System.in);
        String arr1 = kb.next();
        String arr2 = kb.next();
        System.out.println(T.solution(arr1, arr2));
    }
}
