package section1;

import java.io.*;
import java.util.*;

public class ExampleFour_Replay {
    /** StringBuilder의 reverse() 메서드 사용 **/
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int num = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < num; i++) {
//            String str = new StringBuilder(br.readLine()).reverse().toString();
//            sb.append(str).append("\n");
//        }
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//    }


    /** 직접 뒤집기 **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            char[] s = str.toCharArray();
            int lt = 0, rt = str.length() - 1;
            while (lt < rt) {
                char tmp = s[rt];
                s[rt] = s[lt];
                s[lt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            sb.append(tmp).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
