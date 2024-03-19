package Baekjoon.step3;

import java.io.*;
import java.util.StringTokenizer;

public class ExampleOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= 9; i++) {
            //메서드를 통해 출력할 데이터를 버퍼에 쓴다. 구구단 결과를 문자열로 만들어 출력
            bw.write(a + " * " + i + " = " + (a * i));
            //구구단 결과를 한 줄씩 출력
            bw.newLine();
        }
        //버퍼에 남아있는 데이터를 출력 스트림으로 밀어내어 실제로 출력
        bw.flush();
    }
}
