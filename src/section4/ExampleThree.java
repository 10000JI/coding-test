package section4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//매출액의 종류
public class ExampleThree {
    public List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        /**
         * 방법 1 , sliding window 방식
         */
//        for (int i = 0; i < k; i++) {
//            //초기에 0부터 3 인덱스까지의 arr을 map에 저장
//            //arr[0]와 arr[2]는 20이므로 동일 Key이다. -> Key는 중복이 불가능하고, value를 2로 설정해주자
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//        }
//        //초기 0번부터 3까지의 map 사이즈 (20,12,10 -> 3) list에 저장
//        list.add(map.size());
//        //다음 인덱스 번호의 값을 map에 추가해주고, 맨 처음으로 오는 인덱스 번호의 값을 map에서 삭제
//        for (int i = k; i < n; i++) {
//            //맨 처음으로 오는 key를 map에서 삭제시에 value가 1이라면 map에 key-value 자체를 제거
//            if (map.get(arr[i - k]) == 1) map.remove(arr[i - k]);
//            //1보다 크다면 포함하는 구간이 처음으로 오는 key와 동일 key를 가지고 있다면 value만 -1 해준다 (key-value 형상 자체는 남아있음)
//            else if (map.get(arr[i-k]) > 1) map.put(arr[i - k], map.get(arr[i - k]) - 1);
//            //arr의 다음 인덱스 번호 값을 map의 key에 추가하고, value도 +1 해준다.
//            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
//            //구간의 크기(=중복x)를 list에 저장
//            list.add(map.size());
//        }
        /**
         * 방법 2, two point 알고리즘 방식 (rt, lt)
         */
        //3일을 구간 먼저 세팅
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            //4일 구간 마저 세팅
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            //구간의 숫자 개수 count
            list.add(map.size());
            //구간 중 처음에 위치했던 key의 value를 -1로 설정
            map.put(arr[lt], map.get(arr[lt]) - 1);
            //구간 중 처음 위치했던 key의 value가 0이라면 삭제
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return list;
    }

    public static void main(String[] args) {
        ExampleThree T = new ExampleThree();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int x : T.solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}
