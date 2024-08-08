package section1;

import java.io.*;

public class ExampleSeven_Replay {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String str = br.readLine().toUpperCase();
//        String answer = "YES";
//        for (int i = 0; i < str.length() / 2; i++) {
//            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
//                answer = "NO";
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(answer);
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine().toUpperCase();
        String answer = "NO";

        String str2 = new StringBuilder(str1).reverse().toString();
        if (str1.equals(str2)) {
            answer = "YES";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
