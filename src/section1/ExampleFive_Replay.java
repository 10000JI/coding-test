package section1;

import java.io.*;

public class ExampleFive_Replay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char[] charArray = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            } else {
                char tmp = charArray[rt];
                charArray[rt] = charArray[lt];
                charArray[lt] = tmp;
                lt++;
                rt--;
            }
        }
//        for (char c : charArray) {
//            bw.write(c);
//        }
        bw.write(String.valueOf(charArray));
        bw.flush();
        bw.close();
    }
}
