package Baekjoon.step8;

import java.io.*;

public class ExampleSix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        //현재까지의 분수 개수 (= x번째 분수가 속한 행까지의 모든 분수들의 개수)
        int count = 0;
        int i = 1;
        int deno = 0;
        int numer = 0;
        while(count < x) {
            count = count + i;
            i++;
        }

        if((i-1)%2 == 0) {
            deno = 1 + (count - x);
            numer = (i-1) - (count-x);
        }else {
            deno = (i-1) - (count-x);
            numer = 1 + (count - x);
        }


        System.out.println(numer  + "/" + deno);
    }
}
