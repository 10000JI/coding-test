package section6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//중복 확인
public class ExampleFive {
    public String soltuion(int n, int[] arr) {
        String answer = "U";
        /**
         * 정렬로 푸는 방법 : nlogn
         */
        Arrays.sort(arr); //오름차순 정렬
        for (int i = 0; i < n-1; i++) { //0번부터 n-1번까지
            if (arr[i] == arr[i + 1]) { //n번째와 n+1과 같으면 D 반환
                return "D";
            }
        }
        /**
         *  HashMap으로 푸는 방법 : O(n)
         */
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int x : arr) {
//            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
//            if (hashMap.get(x) >= 2) {
//                return "D";
//            }
//        }
        return answer;
    }

    public static void main(String[] args) {
        ExampleFive T = new ExampleFive();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.soltuion(n,arr));
    }
}
