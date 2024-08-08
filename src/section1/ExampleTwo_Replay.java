package section1;

import java.io.*;

public class ExampleTwo_Replay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        String answer = "";
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }
        }

        bw.write(answer); //버퍼에 출력문 저장
        bw.flush(); //버퍼 안에 저장되어 있는 모든 문자열 출력
        //버퍼가 다 찬 경우엔 자동으로 flush()를 통해 모든 문자열이 출력
        bw.close(); //close()를 통해 스트림 종료
    }
}
