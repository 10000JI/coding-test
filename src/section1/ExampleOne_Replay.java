package section1;

import java.io.*;

public class ExampleOne_Replay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        char c = br.readLine().charAt(0);
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x == c) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
