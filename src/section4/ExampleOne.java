package section4;

import java.util.HashMap;
import java.util.Scanner;

//학급 회장(해쉬)
public class ExampleOne {
    public char solution(int n, String str) {
        char answer = ' ';
        int max = Integer.MIN_VALUE;
        //HashMap의 key값은 알파벳, value는 알파벳의 개수를 저장할 것이다.
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            //hashMap.getOrDefault(c,0)+1 : c의 Key 값을 가져오되(알파벳 개수), 없다면 0으로 리턴
            //HashMap은 순서 X(순서가 보장되어 있지 않고), 중복 X(동일 Key이면 값(Value)는 덮어쓰기 된다
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        //hashMap.keySet(): 모든 key들을 반환
        for (char key : hashMap.keySet()) {
            // hashMap.get(key): key 값(value)
            if (hashMap.get(key) > max) {
                max = hashMap.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleOne T = new ExampleOne();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(T.solution(n, str));
    }

}
