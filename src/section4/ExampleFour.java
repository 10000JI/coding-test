package section4;

import java.util.HashMap;
import java.util.Scanner;

//모든 아나그램 찾기
public class ExampleFour {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        //b의 문자열을 HashMap인 bm에 저장
        for (char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
        //a의 문자열을 b의 문자열 길이보다 -1 작은 길이만큼 HashMap인 am에 저장 (만약 b가 3개의 문자가 담긴 문자열이라면 2개의 문자만 map에 저장)
        for (int i=0; i < b.length()-1; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        //마지막 문자를 am에 저장하고, am과 bm이 동일한지(=아나그램인지) 확인 후 answer++
        //이후에는 am의 첫번째로 저장한 entry에 value 값을 -1 해주고, value가 0이라면 해당 entry를 삭제
        int lt = 0;
        for (int rt = b.length()-1; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if(am.equals(bm)) answer++;
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }
        return answer;
    }
    public static void main(String args[]) {
        ExampleFour T = new ExampleFour();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(T.solution(a,b));
    }
}