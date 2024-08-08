package section1;

import java.io.*;

public class ExampleSix_Replay {
    /** 세번째로 빠름 **/
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String str = br.readLine();
//
//        for (int i = 0; i < str.length(); i++) {
//            if (str.indexOf(str.charAt(i)) == i) {
//                bw.write(str.charAt(i));
//            }
//        }
//
//        bw.flush();
//        bw.close();
//    }

    /** 두번째로 빠름 **/
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.indexOf(str.charAt(i)) == i) {
//                sb.append(str.charAt(i));
//            }
//        }
//
//        System.out.print(sb);
//    }

    /** 첫번째로 빠름 **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                sb.append(str.charAt(i));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
