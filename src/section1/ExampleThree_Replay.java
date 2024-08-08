package section1;

import java.io.*;
import java.util.*;

public class ExampleThree_Replay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxLength = Integer.MIN_VALUE;
        String answer = "";
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            arr.add(s);
            if (s.length() > maxLength) {
                maxLength = s.length();
                answer = s;
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
    }
}
